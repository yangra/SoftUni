package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.binding.Import.CarImportDto;
import softuni.dto.view.Query2.CarToyotaDto;
import softuni.dto.view.Query4.CarPartsDto;
//import softuni.dto.view.Query4.CarPartsXmlDto;
import softuni.dto.view.Query4.CarPartsXmlDto;
import softuni.dto.view.Query4.CarPropertiesDto;
import softuni.dto.view.Query4.PartNamePriceDto;
import softuni.entities.Car;
import softuni.entities.Part;
import softuni.io.ModelParser;
import softuni.repositories.CarRepo;
import softuni.services.api.CarService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;

    @Autowired
    public CarServiceImpl(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @Override
    public void saveCarDto(CarImportDto carImportDto) {
        Car car = ModelParser.getInstance().map(carImportDto,Car.class);
        this.carRepo.saveAndFlush(car);
    }

    @Override
    public List<Car> findAll() {
        return this.carRepo.findAll();
    }

    @Override
    public List<CarToyotaDto> getAllToyotas() {
        List<Car> carsToyota = this.carRepo.findByMakeOrderByModelAscTravelledDistanceDesc("Toyota");
        List<CarToyotaDto> carToyotaDtos = new ArrayList<>();
        for (Car car : carsToyota) {
            CarToyotaDto carToyotaDto = ModelParser.getInstance().map(car,CarToyotaDto.class);
            carToyotaDtos.add(carToyotaDto);
        }

        return carToyotaDtos;
    }

    @Override
    public List<CarPartsDto> getAllCars() {
        List<Car> cars = this.carRepo.findAll();
        List<CarPartsDto> carPartsDtos = new ArrayList<>();

        for (Car car : cars) {
            CarPartsDto carPartsDto = new CarPartsDto();
            CarPropertiesDto carPropertiesDto = ModelParser.getInstance().map(car,CarPropertiesDto.class);
            carPartsDto.setCar(carPropertiesDto);

            Set<PartNamePriceDto> partNamePriceDtoSet = new HashSet<>();
            for (Part part : car.getParts()) {
                PartNamePriceDto partNamePriceDto = ModelParser.getInstance().map(part,PartNamePriceDto.class);
                partNamePriceDtoSet.add(partNamePriceDto);
            }

            carPartsDto.setParts(partNamePriceDtoSet);

            carPartsDtos.add(carPartsDto);
        }
        return carPartsDtos;
    }

    @Override
    public List<CarPartsXmlDto> getAllCarsWithPartsXML() {
        List<Car> cars = this.carRepo.findAll();
        List<CarPartsXmlDto> carPartsXmlDtos = new ArrayList<>();

        for (Car car : cars) {
            CarPartsXmlDto carPartsXmlDto = ModelParser.getInstance().map(car,CarPartsXmlDto.class);

            Set<PartNamePriceDto> partNamePriceDtoSet = new HashSet<>();
            for (Part part : car.getParts()) {
                PartNamePriceDto partNamePriceDto = ModelParser.getInstance().map(part,PartNamePriceDto.class);
                partNamePriceDtoSet.add(partNamePriceDto);
            }

            carPartsXmlDto.setParts(partNamePriceDtoSet);
            carPartsXmlDtos.add(carPartsXmlDto);
        }

        return carPartsXmlDtos;
    }


}
