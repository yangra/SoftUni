package softuni.services.api;


import softuni.dto.binding.Import.CarImportDto;
import softuni.dto.view.Query2.CarToyotaDto;
import softuni.dto.view.Query4.CarPartsDto;
import softuni.dto.view.Query4.CarPartsXmlDto;
import softuni.entities.Car;

import java.util.List;

public interface CarService {
    void saveCarDto(CarImportDto carImportDto);

    List<Car> findAll();

    List<CarToyotaDto> getAllToyotas();

    List<CarPartsDto> getAllCars();

    List<CarPartsXmlDto> getAllCarsWithPartsXML();
}
