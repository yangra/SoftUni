package softuni.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.dto.Export.*;
import softuni.dto.Import.*;
import softuni.entities.*;
import softuni.io.JsonParser;
import softuni.io.ModelParser;
import softuni.io.XMLParser;
import softuni.services.api.*;
import softuni.utils.DataValidator;

import javax.validation.ConstraintViolationException;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;

@Component
public class Terminal implements CommandLineRunner {
    private final AccessoryService accessoryService;
    private final CameraService cameraService;
    private final LensService lensService;
    private final PhotographerService photographerService;
    private final WorkshopService workshopService;
    private final XMLParser xmlParser;
    private final JsonParser jsonParser;

    @Autowired
    public Terminal(AccessoryService accessoryService, CameraService cameraService, LensService lensService, PhotographerService photographerService, WorkshopService workshopService, XMLParser xmlParser, JsonParser jsonParser) {
        this.accessoryService = accessoryService;
        this.cameraService = cameraService;
        this.lensService = lensService;
        this.photographerService = photographerService;
        this.workshopService = workshopService;
        this.xmlParser = xmlParser;
        this.jsonParser = jsonParser;
    }


    @Override
    public void run(String... strings) throws Exception {
//        importLensesJson();
//        importCamerasJson();
//        importPhotographersJson();
//        importAccessoriesXml();
//        importWorkshopsXml();

//        exportPhotographersOrderedJson();
//        exportLandscapePhotographersJson();
//        exportSameCameraPhotographersXml();
//        exportWorkshopsByLocationXml();
    }

    private void exportWorkshopsByLocationXml() {
        Map<String, List<WorkshopExportXmlDto>> locations = new HashMap<>();
        List<Workshop> orderedWorkshops = this.workshopService.getAllOrdered();
        for (Workshop workshop : orderedWorkshops) {
            if (workshop.getParticipants().size() >= 5) {
                WorkshopExportXmlDto workshopExportXmlDto = ModelParser.getInstance().map(workshop, WorkshopExportXmlDto.class);
                String location = workshop.getLocation();
                if (locations.keySet().contains(location)) {
                    List<WorkshopExportXmlDto> workshops = locations.get(location);
                    workshops.add(workshopExportXmlDto);
                    locations.put(location, workshops);
                } else {
                    List<WorkshopExportXmlDto> workshops = new ArrayList<>();
                    workshops.add(workshopExportXmlDto);
                    locations.put(location, workshops);
                }
            }
        }
        LocationsExportXmlDto locationsExportXmlDto = new LocationsExportXmlDto();
        List<LocationExportXmlDto> locationDtos = new ArrayList<>();
        for (String location : locations.keySet()) {
            List<WorkshopExportXmlDto> workshopDtos = locations.get(location);
            LocationExportXmlDto locationExportXmlDto = new LocationExportXmlDto();
            locationExportXmlDto.setLocation(location);
            locationExportXmlDto.setWorkshopExportXmlDtos(workshopDtos);
            locationDtos.add(locationExportXmlDto);
        }
        locationsExportXmlDto.setLocationExportXmlDtos(locationDtos);
        try {
            this.xmlParser.serialize(locationsExportXmlDto, "src/main/resources/files/xml/out/workshops-by-location.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void exportSameCameraPhotographersXml() {
        List<Photographer> photographers = this.photographerService.getAllSameCamera();
        PhotographersSameCameraXmlExportDto photographersSameCameraXmlExportDto = new PhotographersSameCameraXmlExportDto();
        List<PhotographerSameCameraXmlExportDto> photographerSameCameraXmlExportDtos = new ArrayList<>();
        for (Photographer photographer : photographers) {
            PhotographerSameCameraXmlExportDto photographerSameCameraXmlExportDto = ModelParser.getInstance().map(photographer, PhotographerSameCameraXmlExportDto.class);
            if (photographerSameCameraXmlExportDto.getLenses().size() < 1) {
                photographerSameCameraXmlExportDto.setLenses(null);
            }
            photographerSameCameraXmlExportDtos.add(photographerSameCameraXmlExportDto);
        }
        photographersSameCameraXmlExportDto.setPhotographerSameCameraXmlExportDtos(photographerSameCameraXmlExportDtos);

        try {
            this.xmlParser.serialize(photographersSameCameraXmlExportDto, "src/main/resources/files/xml/out/same-cameras-photographers.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportLandscapePhotographersJson() {
        List<Photographer> photographers = this.photographerService.getLandscapePhotographers();
        List<PhotographerLandscaperExportDto> photographerLandscaperExportDtos = new ArrayList<>();
        for (Photographer photographer : photographers) {
            PhotographerLandscaperExportDto photographerLandscaperExportDto = ModelParser
                    .getInstance()
                    .map(photographer, PhotographerLandscaperExportDto.class);
            photographerLandscaperExportDto.setLensesCount(photographer.getLenses().size());
            photographerLandscaperExportDtos.add(photographerLandscaperExportDto);
        }
        this.jsonParser.serialize(photographerLandscaperExportDtos, "/src/main/resources/files/json/out/landscape-photographers.json");


    }

    private void exportPhotographersOrderedJson() {
        List<Photographer> photographers = this.photographerService.getAllOrdered();
        List<PhotographersOrderedExportJsonDto> photographersOrderedExportJsonDtos = new ArrayList<>();
        for (Photographer photographer : photographers) {
            PhotographersOrderedExportJsonDto photographersOrderedExportJsonDto = ModelParser
                    .getInstance().map(photographer, PhotographersOrderedExportJsonDto.class);
            photographersOrderedExportJsonDtos.add(photographersOrderedExportJsonDto);
        }
        this.jsonParser.serialize(photographersOrderedExportJsonDtos, "/src/main/resources/files/json/out/photographers-ordered.json");

    }

    private void importWorkshopsXml() {
        try {
            WorkshopsImportXmlDto workshopsImportXmlDto = this.xmlParser
                    .deserialize(WorkshopsImportXmlDto.class, "/files/xml/in/workshops.xml");
            for (WorkshopImportXmlDto workshopImportXmlDto : workshopsImportXmlDto.getWorkshopImportXmlDtos()) {
                Workshop workshop = ModelParser.getInstance().map(workshopImportXmlDto, Workshop.class);
                this.workshopService.addWorkshop(workshop);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importAccessoriesXml() {
        try {
            AccessoriesImportXmlDto accessoriesImportXmlDto = this.xmlParser.deserialize(AccessoriesImportXmlDto.class, "/files/xml/in/accessories.xml");
            for (AccessoryImportXmlDto accessoryImportXmlDto : accessoriesImportXmlDto.getAccessoryImportXmlDtos()) {
                Accessory accessory = ModelParser.getInstance().map(accessoryImportXmlDto, Accessory.class);
                this.accessoryService.addAccessory(accessory);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importPhotographersJson() {
        PhotographerImportJsonDto[] photographerImportJsonDtos = this.jsonParser.deserialize(PhotographerImportJsonDto[].class, "/files/json/in/photographers.json");
        List<Camera> cameras = this.cameraService.findAll();
        List<Lens> lenses = this.lensService.findAll();
        Random random = new Random();
        for (PhotographerImportJsonDto photographerImportJsonDto : photographerImportJsonDtos) {
            if (!DataValidator.validate(photographerImportJsonDto)) {
                System.out.println("Error. Invalid data provided.");
            } else {

                Photographer photographer = ModelParser.getInstance().map(photographerImportJsonDto, Photographer.class);
//                if (!DataValidator.validateField(photographer, "phone")) {
//                    photographer.setPhone(null);
//                }
                if (photographer.getPhone() != null && !photographer.getPhone().matches("\\+[0-9]{1,3}\\/[0-9]{8,10}")) {
                    photographer.setPhone(null);
                }
                photographer.setPrimaryCamera(cameras.get(random.nextInt(cameras.size())));
                photographer.setSecondaryCamera(cameras.get(random.nextInt(cameras.size())));
                Set<Lens> photoLenses = new HashSet<>();
                for (Integer lensId : photographerImportJsonDto.getLensIds()) {
                    if (lensId >= 0 && lensId < lenses.size() &&
                            (lenses.get(lensId).getCompatibleWith().equals(photographer.getPrimaryCamera().getMake()) ||
                                    lenses.get(lensId).getCompatibleWith().equals(photographer.getSecondaryCamera().getMake()))) {
                        Lens lens = lenses.get(lensId);
                        photoLenses.add(lens);
                        lens.setOwner(photographer);
                    }
                }
                photographer.setLenses(photoLenses);
                this.photographerService.save(photographer);
//                for (Lens photoLens : photoLenses) {
//                    photoLens.setOwner(persistedPhotographer);
//                }


                System.out.printf("Successfully imported %s %s | Lenses: %d",
                        photographer.getFirstName(),
                        photographer.getLastName(),
                        photographer.getLenses().size());
            }
        }
    }

    private void importCamerasJson() {
        CameraImportJsonDto[] cameraImportJsonDtos = this.jsonParser.deserialize(CameraImportJsonDto[].class, "/files/json/in/cameras.json");
        for (CameraImportJsonDto cameraImportJsonDto : cameraImportJsonDtos) {
            try {
                this.cameraService.saveCameraImportDto(cameraImportJsonDto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void importLensesJson() {
        LensImportJsonDto[] lensImportJsonDtos = this.jsonParser.deserialize(LensImportJsonDto[].class, "/files/json/in/lenses.json");
        for (LensImportJsonDto lensImportJsonDto : lensImportJsonDtos) {
            this.lensService.saveLensDto(lensImportJsonDto);
        }
    }
}
