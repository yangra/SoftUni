package softuni.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.dto.Import.CameraImportJsonDto;
import softuni.entities.Camera;
import softuni.entities.DSLRCamera;
import softuni.entities.MirrorlessCamera;
import softuni.io.ModelParser;
import softuni.repositories.CameraRepository;
import softuni.services.api.CameraService;
import softuni.utils.DataValidator;

import java.util.List;

@Service
@Transactional
public class CameraServiceImpl implements CameraService {
    private final CameraRepository cameraRepository;

    @Autowired
    public CameraServiceImpl(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    @Override
    public void saveCameraImportDto(CameraImportJsonDto cameraImportJsonDto) {
        Camera camera = null;
        if(!DataValidator.validate(cameraImportJsonDto)){
            throw new IllegalArgumentException("Invalid data.");
        }
        else if(cameraImportJsonDto.getType().equals("DSLR")){
            camera = ModelParser.getInstance().map(cameraImportJsonDto,DSLRCamera.class);
        }
        else if(cameraImportJsonDto.getType().equals("Mirrorless")){
            camera = ModelParser.getInstance().map(cameraImportJsonDto,MirrorlessCamera.class);
        }
        if(camera!=null){
        this.cameraRepository.saveAndFlush(camera);
        System.out.printf("Successfully imported %s %s %s",
                    cameraImportJsonDto.getType(), camera.getMake(), camera.getModel());
        } else{
            throw new IllegalArgumentException("Invalid data.");
        }
    }

    @Override
    public List<Camera> findAll() {
        return this.cameraRepository.findAll();
    }
}
