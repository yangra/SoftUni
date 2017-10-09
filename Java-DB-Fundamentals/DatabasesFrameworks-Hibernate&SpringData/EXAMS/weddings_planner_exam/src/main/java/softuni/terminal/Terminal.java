package softuni.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.dto.Export.AgencyExportJsonDto;
import softuni.dto.Export.TownsExportXmlDto;
import softuni.dto.Export.VenuesExportXmlDto;
import softuni.dto.Export.WeddingExportJsonDto;
import softuni.dto.Import.*;
import softuni.entities.Agency;
import softuni.entities.Person;
import softuni.entities.Venue;
import softuni.entities.Wedding;
import softuni.entities.enums.Gender;
import softuni.io.JsonParser;
import softuni.io.XmlParser;
import softuni.services.api.*;
import softuni.utils.DataValidator;
import softuni.utils.ModelParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Component
public class Terminal implements CommandLineRunner{
    private final XmlParser xmlParser;
    private final JsonParser jsonParser;
    private final AgencyService agencyService;
    private final InvitationService invitationService;
    private final PersonService personService;
    private final PresentService presentService;
    private final VenueService venueService;
    private final WeddingService weddingService;

    @Autowired
    public Terminal(XmlParser xmlParser, JsonParser jsonParser, AgencyService agencyService, InvitationService invitationService, PersonService personService, PresentService presentService, VenueService venueService, WeddingService weddingService) {
        this.xmlParser = xmlParser;
        this.jsonParser = jsonParser;
        this.agencyService = agencyService;
        this.invitationService = invitationService;
        this.personService = personService;
        this.presentService = presentService;
        this.venueService = venueService;
        this.weddingService = weddingService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        importAgenciesJson();
//        importPeopleJson();
//        importWeddingsAndInvitationsJson();
//        importVenuesXml();
//        addRandomTwoVenuesForEveryWedding();
//        importPresentsXml();

//        exportOrderedAgenciesJson();
//        exportGuestsJson();
//        exportVenuesXml();
        exportAgencieByTown();
    }

    private void exportAgencieByTown() {
        TownsExportXmlDto townsExportDto = this.agencyService.getAgenciesByTowns();
        try {
            this.xmlParser.serialize(townsExportDto,"src/main/resources/files/xml/out/agencies-by-town.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportVenuesXml() {
        VenuesExportXmlDto venuesExportDto = this.venueService.getVenuesIn("Sofia", 3);
        try {
            this.xmlParser.serialize(venuesExportDto,"src/main/resources/files/xml/out/sofia-venues.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportGuestsJson() {
        List<WeddingExportJsonDto> weddingExportDtos  = this.weddingService.getWeddingDetails();
        this.jsonParser.serialize(weddingExportDtos, "/src/main/resources/files/json/out/guests.json");
    }

    private void exportOrderedAgenciesJson() {
        List<AgencyExportJsonDto> agencyExportDtos = this.agencyService.getAllOrdered();
        this.jsonParser.serialize(agencyExportDtos, "/src/main/resources/files/json/out/agencies-ordered.json");
    }

    private void importPresentsXml() {
        try {
            PresentsImportXmlDto presentsImportXmlDto = this.xmlParser
                    .deserialize(PresentsImportXmlDto.class, "/files/xml/in/presents.xml");
            for (PresentImportXmlDto presentImportDto : presentsImportXmlDto.getPresentImportXmlDtos()) {
                this.presentService.saveDto(presentImportDto);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addRandomTwoVenuesForEveryWedding() {
        List<Venue> venues = this.venueService.getAll();
        List<Wedding> weddings = this.weddingService.getAll();
        Random random = new Random();
        for (Wedding wedding : weddings) {
            Set<Venue> venueSet = new HashSet<>();
            for (int i = 0; i < 2; i++) {
                Venue venue = venues.get(random.nextInt(venues.size()));
                while(venueSet.contains(venue)){
                    venue = venues.get(random.nextInt(venues.size()));
                }
                venueSet.add(venue);
            }
            wedding.setVenues(venueSet);
            this.weddingService.save(wedding);
        }

    }

    private void importVenuesXml() {
        try {
            VenuesImportXmlDto venuesImportXmlDto = this.xmlParser
                    .deserialize(VenuesImportXmlDto.class, "/files/xml/in/venues.xml");
            for (VenueImportXmlDto venueImportDto : venuesImportXmlDto.getVenueImportXmlDtos()) {
                this.venueService.saveDto(venueImportDto);
                System.out.printf("Successfully imported venue %s\n",venueImportDto.getName());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importWeddingsAndInvitationsJson() {
        WeddingImportJsonDto[] weddingDtos = this.jsonParser
                .deserialize(WeddingImportJsonDto[].class,"/files/json/in/weddings.json" );
        for (WeddingImportJsonDto weddingDto : weddingDtos) {
            this.weddingService.saveDto(weddingDto);
        }
    }

    private void importPeopleJson() {
        PersonImpoertJsonDto[] personImportDtos = this.jsonParser
                .deserialize(PersonImpoertJsonDto[].class, "/files/json/in/people.json");
        for (PersonImpoertJsonDto personImportDto : personImportDtos) {
            Person person = ModelParser.getInstance().map(personImportDto,Person.class);
            if(DataValidator.validate(person)){
                if(person.getGender()==null){
                    person.setGender(Gender.NotSpecified);
                }
                this.personService.save(person);
                System.out.printf("Successfully imported %s\n", person.getFullName());

            }else{
                System.out.println("Error. Invalid data provided");
            }
        }
    }

    private void importAgenciesJson() {
        AgencyImportDto[] agencyImportDtos = this.jsonParser
                .deserialize(AgencyImportDto[].class, "/files/json/in/agencies.json");
        for (AgencyImportDto agencyImportDto : agencyImportDtos) {
            Agency agency = ModelParser.getInstance().map(agencyImportDto,Agency.class);
            this.agencyService.save(agency);
            System.out.printf("Successfully imported %s\n", agency.getName());
        }
    }
}
