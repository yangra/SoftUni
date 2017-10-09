package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.Import.PresentImportXmlDto;
import softuni.entities.Cash;
import softuni.entities.Gift;
import softuni.entities.Invitation;
import softuni.entities.Person;
import softuni.entities.enums.Size;
import softuni.repositories.InvitationRepository;
import softuni.repositories.PresentRepository;
import softuni.services.api.PresentService;
import softuni.utils.ModelParser;

import javax.transaction.Transactional;

@Service
@Transactional
public class PresentServiceImpl implements PresentService {
    private final PresentRepository presentRepository;
    private final InvitationRepository invitationRepository;

    @Autowired
    public PresentServiceImpl(PresentRepository presentRepository, InvitationRepository invitationRepository) {
        this.presentRepository = presentRepository;
        this.invitationRepository = invitationRepository;
    }

    @Override
    public void saveDto(PresentImportXmlDto presentImportDto) {
        if(presentImportDto.getType()!=null&& presentImportDto.getOwner()!=null){
            Invitation invitation = this.invitationRepository.findOne(Long.parseLong(presentImportDto.getOwner()));
            if(invitation == null){
                return;
            }
            Person owner = invitation.getGuest();
            if(presentImportDto.getType().equals("cash")&& presentImportDto.getCashAmount()!=null){
                Cash cash = ModelParser.getInstance().map(presentImportDto, Cash.class);
                cash.setOwner(owner);
                this.presentRepository.saveAndFlush(cash);
                invitation.setPresent(cash);
                this.invitationRepository.saveAndFlush(invitation);
                System.out.printf("Successfully imported present from %s\n", owner.getFullName());
            }
            if(presentImportDto.getType().equals("gift")&& presentImportDto.getName()!=null){
                Gift gift = ModelParser.getInstance().map(presentImportDto, Gift.class);
                gift.setOwner(owner);
                if(gift.getSize()==null){
                    gift.setSize(Size.NotSpecified);
                }
                this.presentRepository.saveAndFlush(gift);
                invitation.setPresent(gift);
                this.invitationRepository.saveAndFlush(invitation);
                System.out.printf("Successfully imported present from %s\n", owner.getFullName());
            }
        }else{
            System.out.println("Error. invalid data provided");
        }
    }
}
