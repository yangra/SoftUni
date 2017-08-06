package softuni.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import softuni.dto.binding.Import.*;
import softuni.dto.binding.XMLDtos.CarsImportXmlDto;
import softuni.dto.binding.XMLDtos.CustomersImportXmlDto;
import softuni.dto.binding.XMLDtos.PartsImportXmlDto;
import softuni.dto.binding.XMLDtos.SuppliersImportXmlDto;
import softuni.dto.view.Query1.CustomerByBirthDateDto;
import softuni.dto.view.Query1.CustomersByBirthDateXmlDto;
import softuni.dto.view.Query2.CarToyotaDto;
import softuni.dto.view.Query2.CarsToyotaXmlDto;
import softuni.dto.view.Query3.SupplierLocalDto;
import softuni.dto.view.Query3.SuppliersLocalXmlDto;
import softuni.dto.view.Query4.CarPartsDto;
import softuni.dto.view.Query4.CarPartsXmlDto;
import softuni.dto.view.Query4.CarsPartsXmlDto;
import softuni.dto.view.Query5.CustomerSalesDto;
import softuni.dto.view.Query5.CustomersSalesXmlDto;
import softuni.dto.view.Query6.SalePropertiesDto;
import softuni.dto.view.Query6.SalesPropertiesXmlDto;
import softuni.entities.Car;
import softuni.entities.Customer;
import softuni.entities.Sale;
import softuni.io.JsonParser;
import softuni.io.XMLParser;
import softuni.services.api.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;

@Component
public class Terminal implements CommandLineRunner {
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final PartService partService;
    private final SupplierService supplierService;
    private final JsonParser jsonParser;
    private final XMLParser xmlParser;

    @Autowired
    public Terminal(CarService carService, CustomerService customerService, SaleService saleService, PartService partService, SupplierService supplierService, JsonParser jsonParser, XMLParser xmlParser) {
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.partService = partService;
        this.supplierService = supplierService;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... strings) throws Exception {

//        ###############  JSON  #############################
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
//        exportSalesProperties();

//        ################  XML  ###############################
//        importSuppliersXML();
//        importPartsXML();
//        importCarsXML();
//        importCustomersXML();
//        importSales();

//        exportCustomersOrderedByBirthDateXML();
//        exportAllToyotasXML();
//        exportLocalSuppliersXML();
        exportCarsWithPartsXML();
//        exportTotalSalesByCustomerXML();
//        exportSalesPropertiesXML();
    }

    private void exportSalesPropertiesXML() {
        SalesPropertiesXmlDto salesPropertiesXmlDto = new SalesPropertiesXmlDto();
        List<SalePropertiesDto> salePropertiesDtos = this.saleService.getSalesProperties();
        salesPropertiesXmlDto.setSalePropertiesDtos(salePropertiesDtos);
        try {
            this.xmlParser.serialize(salesPropertiesXmlDto,"src/main/resources/files/xml/out/SalesProperties.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportTotalSalesByCustomerXML() {
        CustomersSalesXmlDto customersSalesXmlDto = new CustomersSalesXmlDto();
        List<CustomerSalesDto> customerSalesDtos = this.customerService.getTotalSalesByCustomer();
        customersSalesXmlDto.setCustomerSalesDtos(customerSalesDtos);
        try {
            this.xmlParser.serialize(customersSalesXmlDto,"src/main/resources/files/xml/out/CustomersTotalSales.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportCarsWithPartsXML() {
        CarsPartsXmlDto carsPartsXmlDto = new CarsPartsXmlDto();
        List<CarPartsXmlDto> carPartsXmlDtos = this.carService.getAllCarsWithPartsXML();
        carsPartsXmlDto.setCarPartsXmlDtos(carPartsXmlDtos);
        try {
            this.xmlParser.serialize(carsPartsXmlDto,"src/main/resources/files/xml/out/CarsWithParts.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportLocalSuppliersXML() {
        SuppliersLocalXmlDto suppliersLocalXmlDto = new SuppliersLocalXmlDto();
        List<SupplierLocalDto> supplierLocalDtos = this.supplierService.getLocalSuppliers();
        suppliersLocalXmlDto.setSupplierLocalDtos(supplierLocalDtos);
        try {
            this.xmlParser.serialize(suppliersLocalXmlDto,"src/main/resources/files/xml/out/LocalSuppliers.xml" );
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportAllToyotasXML() {
        CarsToyotaXmlDto carsToyotaXmlDto = new CarsToyotaXmlDto();
        List<CarToyotaDto> carToyotaDtos = this.carService.getAllToyotas();
        carsToyotaXmlDto.setCarToyotaDtos(carToyotaDtos);
        try {
            this.xmlParser.serialize(carsToyotaXmlDto,"src/main/resources/files/xml/out/CarsToyota.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportCustomersOrderedByBirthDateXML() {
        CustomersByBirthDateXmlDto customersByBirthDateXmlDto = new CustomersByBirthDateXmlDto();
        List<CustomerByBirthDateDto> customerByBirthDateDtos = this.customerService.getAllOrderedByBirthDate();
        customersByBirthDateXmlDto.setCustomerByBirthDateDtos(customerByBirthDateDtos);
        try {
            this.xmlParser.serialize(customersByBirthDateXmlDto,"src/main/resources/files/xml/out/CustomersByBirthDate.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importCustomersXML() {
        try {
            CustomersImportXmlDto customersImportXmlDto = this.xmlParser
                    .deserialize(CustomersImportXmlDto.class, "/files/xml/in/customers.xml");
            for (CustomerImportDto customerImportDto : customersImportXmlDto.getCustomerImportDtos()) {
                this.customerService.saveCustomerDto(customerImportDto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void importCarsXML() {
        try {
            CarsImportXmlDto carsImportXmlDto = this.xmlParser
                    .deserialize(CarsImportXmlDto.class, "/files/xml/in/cars.xml");
            Random random = new Random();
            List<PartDto> parts = this.partService.findAllPartDto();

            for (CarImportDto carImportDto : carsImportXmlDto.getCarImportDtos()) {
                Integer rand = random.nextInt(11);
                Set<PartDto> partDtos = new HashSet<>();
                for (int i = 0; i < 10 + rand; i++) {
                    partDtos.add(parts.get(random.nextInt(parts.size())));
                }

                carImportDto.setParts(partDtos);
                this.carService.saveCarDto(carImportDto);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void importPartsXML() {
        try {
            PartsImportXmlDto partImportXmlDtos = this.xmlParser
                    .deserialize(PartsImportXmlDto.class, "/files/xml/in/parts.xml");
            Random random = new Random();
            List<SupplierDto> supplierDtos = this.supplierService.findAllSupplierDto();
            for (PartImportDto partImportDto : partImportXmlDtos.getPartImportDtos()) {
                partImportDto.setSupplier(supplierDtos.get(random.nextInt(supplierDtos.size())));
                this.partService.savePartDto(partImportDto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    private void importSuppliersXML() {
        try {
            SuppliersImportXmlDto suppliersImportXmlDto = this.xmlParser
                    .deserialize(SuppliersImportXmlDto.class, "/files/xml/in/suppliers.xml");
            for (SupplierImportDto supplierImportDto : suppliersImportXmlDto.getSupplierImportDtos()) {
                this.supplierService.saveSupplierDto(supplierImportDto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void exportSalesProperties() {
        List<SalePropertiesDto> salePropertiesDtos = this.saleService.getSalesProperties();
        this.jsonParser.serialize(salePropertiesDtos, "/src/main/resources/files/json/out/SalesProperties.json");
    }

    private void exportTotalSalesByCustomer() {
        List<CustomerSalesDto> customerSalesDtos = this.customerService.getTotalSalesByCustomer();
        this.jsonParser.serialize(customerSalesDtos, "/src/main/resources/files/json/out/TotalSalesByCustomer.json");
    }

    private void exportAllCarsWithTheirParts() {
        List<CarPartsDto> carPartsDtos = this.carService.getAllCars();
        this.jsonParser.serialize(carPartsDtos, "/src/main/resources/files/json/out/CarsWithTheirParts.json");
    }

    private void exportAllLocalSuppliers() {
        List<SupplierLocalDto> supplierLocalDtos = this.supplierService.getLocalSuppliers();
        this.jsonParser.serialize(supplierLocalDtos, "/src/main/resources/files/json/out/LocalSuppliers.json");
    }

    private void exportAllToyotas() {
        List<CarToyotaDto> carToyotaDtos = this.carService.getAllToyotas();
        this.jsonParser.serialize(carToyotaDtos, "/src/main/resources/files/json/out/toyotasByModel.json");
    }

    private void exportCustomersOrderedByBirthDate() {
        List<CustomerByBirthDateDto> customerByBirthDateDtos = this.customerService.getAllOrderedByBirthDate();
        this.jsonParser.serialize(customerByBirthDateDtos, "/src/main/resources/files/json/out/customersByBirthDate.json");
    }

    private void importSales() {
        for (int i = 0; i < 50; i++) {
            Sale sale = new Sale();
            Random random = new Random();
            List<Car> cars = this.carService.findAll();
            List<Customer> customers = this.customerService.findAll();
            Integer[] discounts = new Integer[]{0, 5, 10, 15, 20, 30, 40, 50};
            sale.setCar(cars.get(random.nextInt(cars.size())));
            sale.setCustomer(customers.get(random.nextInt(customers.size())));
            sale.setDiscount(discounts[random.nextInt(discounts.length)]);
            if (sale.getCustomer().getYoungDriver()) {
                sale.setDiscount(sale.getDiscount() + 5);
            }
            this.saleService.save(sale);
        }


    }

    private void importCustomers() {
        CustomerImportDto[] customerImportDtos = this.jsonParser.deserialize(CustomerImportDto[].class, "/files/json/in/customers.json");
        for (CustomerImportDto customerImportDto : customerImportDtos) {
            this.customerService.saveCustomerDto(customerImportDto);
        }
    }

    private void importCars() {
        CarImportDto[] carImportDtos = this.jsonParser.deserialize(CarImportDto[].class, "/files/json/in/cars.json");
        Random random = new Random();
        List<PartDto> partDtos = this.partService.findAllPartDto();
        for (CarImportDto carImportDto : carImportDtos) {
            Set<PartDto> partDtoSet = new HashSet<>();
            int insert = random.nextInt(11);
            for (int i = 0; i < 10 + insert; i++) {
                partDtoSet.add(partDtos.get(random.nextInt(partDtos.size())));
            }
            carImportDto.setParts(partDtoSet);
            this.carService.saveCarDto(carImportDto);
        }
    }

    private void importParts() {
        PartImportDto[] partImportDtos = this.jsonParser.deserialize(PartImportDto[].class, "/files/json/in/parts.json");
        Random random = new Random();
        List<SupplierDto> supplierDtos = this.supplierService.findAllSupplierDto();
        for (PartImportDto partImportDto : partImportDtos) {
            partImportDto.setSupplier(supplierDtos.get(random.nextInt(supplierDtos.size())));
            this.partService.savePartDto(partImportDto);
        }
    }

    private void importSuppliers() {
        SupplierImportDto[] supplierImportDtos = this.jsonParser.deserialize(SupplierImportDto[].class, "/files/json/in/suppliers.json");
        for (SupplierImportDto supplierImportDto : supplierImportDtos) {
            this.supplierService.saveSupplierDto(supplierImportDto);
        }
    }
}
