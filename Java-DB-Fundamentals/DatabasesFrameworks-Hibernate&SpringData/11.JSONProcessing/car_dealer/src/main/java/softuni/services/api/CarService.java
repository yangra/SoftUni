package softuni.services.api;


import softuni.dto.JsonImport.CarImportJsonDto;
import softuni.dto.JsonQuery.Query2.CarToyotaDto;
import softuni.dto.JsonQuery.Query4.CarPartsDto;
import softuni.entities.Car;

import java.util.List;

public interface CarService {
    void saveCarDto(CarImportJsonDto carImportJsonDto);

    List<Car> findAll();

    List<CarToyotaDto> getAllToyotas();

    List<CarPartsDto> getAllCars();
}
