package softuni.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import softuni.dto.JsonImport.CarImportJsonDto;
import softuni.dto.JsonImport.CustomerImportJsonDto;
import softuni.dto.JsonImport.PartImportJsonDto;
import softuni.dto.JsonImport.SupplierImportJsonDto;
import softuni.dto.JsonQuery.Query1.CustomersByBirthDateDto;
import softuni.dto.JsonQuery.Query2.CarToyotaDto;
import softuni.dto.JsonImport.PartDto;
import softuni.dto.JsonImport.SupplierDto;
import softuni.dto.JsonQuery.Query3.SupplierLocalDto;
import softuni.dto.JsonQuery.Query4.CarPartsDto;
import softuni.dto.JsonQuery.Query5.CustomerSalesDto;
import softuni.dto.JsonQuery.Query6.SalePropertiesDto;
import softuni.entities.Car;
import softuni.entities.Customer;
import softuni.entities.Sale;
import softuni.io.JsonParser;
import softuni.services.api.*;

import java.util.*;

@Component
public class Terminal implements CommandLineRunner {
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final PartService partService;
    private final SupplierService supplierService;
    private final JsonParser jsonParser;

    @Autowired
    public Terminal(CarService carService, CustomerService customerService, SaleService saleService, PartService partService, SupplierService supplierService, JsonParser jsonParser) {
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.partService = partService;
        this.supplierService = supplierService;
        this.jsonParser = jsonParser;
    }

    @Override
    public void run(String... strings) throws Exception {
//        importSuppliers();
//        importParts();
//        importCars();
//        importCustomers();
//        importSales();

//        exportCustomersOrderedByBirthDate();
//        exportAllToyotas();
//        exportAllLocalSuppliers();
//        exportAllCarsWithTheirParts();
//        exportTotalSalesByCustomer();
        exportSalesProperties();
    }

    private void exportSalesProperties() {
        List<SalePropertiesDto> salePropertiesDtos = this.saleService.getSaleProperties();
        this.jsonParser.serialize(salePropertiesDtos,"/src/main/resources/files/json/out/SalesProperties.json");
    }

    private void exportTotalSalesByCustomer() {
        List<CustomerSalesDto> customerSalesDtos = this.customerService.getTotalSalesByCustomer();
        this.jsonParser.serialize(customerSalesDtos,"/src/main/resources/files/json/out/TotalSalesByCustomer.json");
    }

    private void exportAllCarsWithTheirParts() {
        List<CarPartsDto> carPartsDtos = this.carService.getAllCars();
        this.jsonParser.serialize(carPartsDtos, "/src/main/resources/files/json/out/CarsWithTheirParts.json");
    }

    private void exportAllLocalSuppliers() {
        List<SupplierLocalDto> supplierLocalDtos = this.supplierService.getLocalSuppliers();
        this.jsonParser.serialize(supplierLocalDtos,"/src/main/resources/files/json/out/LocalSuppliers.json");
    }

    private void exportAllToyotas() {
        List<CarToyotaDto> carToyotaDtos = this.carService.getAllToyotas();
        this.jsonParser.serialize(carToyotaDtos,"/src/main/resources/files/json/out/toyotasByModel.json");
    }

    private void exportCustomersOrderedByBirthDate() {
        List<CustomersByBirthDateDto> customersByBirthDateDtos = this.customerService.getAllOrderedByBirthDate();
        this.jsonParser.serialize(customersByBirthDateDtos,"/src/main/resources/files/json/out/customersByBirthDate.json");
    }

    private void importSales() {
        for (int i = 0; i < 50; i++) {
            Sale sale = new Sale();
            Random random = new Random();
            List<Car> cars = this.carService.findAll();
            List<Customer> customers = this.customerService.findAll();
            Integer[] discounts = new Integer[]{0,5,10,15,20,30,40,50};
            sale.setCar(cars.get(random.nextInt(cars.size())));
            sale.setCustomer(customers.get(random.nextInt(customers.size())));
            sale.setDiscount(discounts[random.nextInt(discounts.length)]);
            if(sale.getCustomer().getYoungDriver()){
                sale.setDiscount(sale.getDiscount()+5);
            }
            this.saleService.save(sale);
        }


    }

    private void importCustomers() {
        CustomerImportJsonDto[] customerImportJsonDtos = this.jsonParser.deserialize(CustomerImportJsonDto[].class, "/files/json/in/customers.json");
        for (CustomerImportJsonDto customerImportJsonDto : customerImportJsonDtos) {
            this.customerService.saveCustomerDto(customerImportJsonDto);
        }
    }

    private void importCars() {
        CarImportJsonDto[] carImportJsonDtos = this.jsonParser.deserialize(CarImportJsonDto[].class, "/files/json/in/cars.json");
        Random random = new Random();
        List<PartDto> partDtos = this.partService.findAllPartDto();
        for (CarImportJsonDto carImportJsonDto : carImportJsonDtos) {
            Set<PartDto> partDtoSet = new HashSet<>();
            int insert = random.nextInt(11);
            for (int i = 0; i < 10 + insert ; i++) {
                partDtoSet.add(partDtos.get(random.nextInt(partDtos.size())));
            }
            carImportJsonDto.setParts(partDtoSet);
            this.carService.saveCarDto(carImportJsonDto);
        }
    }

    private void importParts() {
        PartImportJsonDto[] partImportJsonDtos = this.jsonParser.deserialize(PartImportJsonDto[].class, "/files/json/in/parts.json");
        Random random = new Random();
        List<SupplierDto> supplierDtos = this.supplierService.findAllSupplierDto();
        for (PartImportJsonDto partImportJsonDto : partImportJsonDtos) {
            partImportJsonDto.setSupplier(supplierDtos.get(random.nextInt(supplierDtos.size())));
            this.partService.savePartDto(partImportJsonDto);
        }
    }

    private void importSuppliers() {
        SupplierImportJsonDto[] supplierImportJsonDtos = this.jsonParser.deserialize(SupplierImportJsonDto[].class, "/files/json/in/suppliers.json");
        for (SupplierImportJsonDto supplierImportJsonDto : supplierImportJsonDtos) {
            this.supplierService.saveSupplierDto(supplierImportJsonDto);
        }
    }
}
