package softuni.services.api;


import softuni.dto.Import.CameraImportJsonDto;
import softuni.entities.Camera;

import java.util.List;

public interface CameraService {
    void saveCameraImportDto(CameraImportJsonDto cameraImportJsonDto);

    List<Camera> findAll();
}
