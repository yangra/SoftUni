package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.Export.WeddingExportJsonDto;
import softuni.dto.Import.GuestImportDto;
import softuni.dto.Import.WeddingImportJsonDto;
import softuni.entities.Agency;
import softuni.entities.Invitation;
import softuni.entities.Person;
import softuni.entities.Wedding;
import softuni.entities.enums.Family;
import softuni.repositories.AgencyRepository;
import softuni.repositories.InvitationRepository;
import softuni.repositories.PersonRepository;
import softuni.repositories.WeddingRepository;
import softuni.services.api.WeddingService;
import softuni.utils.DataValidator;
import softuni.utils.ModelParser;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WeddingServiceImpl implements WeddingService {
    private final WeddingRepository weddingRepository;
    private final InvitationRepository invitationRepository;
    private final PersonRepository personRepository;
    private final AgencyRepository agencyRepository;

    @Autowired
    public WeddingServiceImpl(WeddingRepository weddingRepository, InvitationRepository invitationRepository, PersonRepository personRepository, AgencyRepository agencyRepository) {
        this.weddingRepository = weddingRepository;
        this.invitationRepository = invitationRepository;
        this.personRepository = personRepository;
        this.agencyRepository = agencyRepository;
    }

    @Override
    public void saveDto(WeddingImportJsonDto weddingDto) {
        if (DataValidator.validate(weddingDto)) {
            Wedding wedding = ModelParser.getInstance().map(weddingDto, Wedding.class);
            String[] brideFullName = weddingDto.getBride().split("\\s+");
            Person bride = this.personRepository
                    .findByFirstNameAndMiddleNameInitialAndLastName(brideFullName[0], brideFullName[1], brideFullName[2]);
            String[] bridegroomFullName = weddingDto.getBridegroom().split("\\s+");
            Person bridegroom = this.personRepository
                    .findByFirstNameAndMiddleNameInitialAndLastName(bridegroomFullName[0], bridegroomFullName[1], bridegroomFullName[2]);
            List<Agency> agencies = this.agencyRepository.findByName(weddingDto.getAgency());
            Agency agency = agencies.stream().findAny().get();
            wedding.setBride(bride);
            wedding.setBridegroom(bridegroom);
            wedding.setAgency(agency);
            if (bride == null || bridegroom == null || agency == null) {
                System.out.println("Error. Invalid data provided");
                return;
            }
            this.weddingRepository.saveAndFlush(wedding);
            for (GuestImportDto guestDto : weddingDto.getGuests()) {

                Invitation invitation = ModelParser.getInstance().map(guestDto, Invitation.class);
                String[] guestFullName = guestDto.getGuest().split("\\s+");
                Person guest = this.personRepository
                        .findByFirstNameAndMiddleNameInitialAndLastName(guestFullName[0], guestFullName[1], guestFullName[2]);
                if (guest == null) {
                    continue;
                }
                invitation.setGuest(guest);
                invitation.setWedding(wedding);
                this.invitationRepository.saveAndFlush(invitation);
                System.out.printf("Successfully imported wedding of %s and %s", brideFullName[0], bridegroomFullName[0]);

            }
        } else {
            System.out.println("Error. Invalid data provided");
        }
    }

    @Override
    public List<Wedding> getAll() {
        return this.weddingRepository.findAll();
    }

    @Override
    public void save(Wedding wedding) {
        this.weddingRepository.saveAndFlush(wedding);
    }

    @Override
    public List<WeddingExportJsonDto> getWeddingDetails() {
        List<Wedding> weddings = this.weddingRepository.findAll();
        List<WeddingExportJsonDto> weddingExportDtos = new ArrayList<>();
        for (Wedding wedding : weddings) {
            WeddingExportJsonDto weddingExportDto = ModelParser.getInstance().map(wedding, WeddingExportJsonDto.class);

            int brideCounter = 0;
            int bridegroomCounter = 0;
            int attendingCounter = 0;
            List<String> guests = new ArrayList<>();
            for (Invitation invitation : wedding.getInvitations()) {
                if(invitation.getAttending()){
                    attendingCounter++;
                    guests.add(invitation.getGuest().getFullName());
                }
                if(invitation.getFamily().equals(Family.Bride)){
                    brideCounter++;
                }
                if(invitation.getFamily().equals(Family.Bridegroom)){
                    bridegroomCounter++;
                }
            }

            weddingExportDto.setInvitedGuests(wedding.getInvitations().size());
            weddingExportDto.setAttendingGuests(attendingCounter);
            weddingExportDto.setBridegroomGuests(bridegroomCounter);
            weddingExportDto.setBrideGuests(brideCounter);
            weddingExportDto.setGuests(guests);

            weddingExportDtos.add(weddingExportDto);
        }

        List<WeddingExportJsonDto> weddingExportDtosOrdered = weddingExportDtos.stream().sorted((a, b) -> {
            int result = b.getInvitedGuests().compareTo(a.getInvitedGuests());
            if (result == 0) {
                result = a.getAttendingGuests().compareTo(b.getAttendingGuests());
            }
            return result;
        }).collect(Collectors.toList());

        return weddingExportDtosOrdered;
    }

}