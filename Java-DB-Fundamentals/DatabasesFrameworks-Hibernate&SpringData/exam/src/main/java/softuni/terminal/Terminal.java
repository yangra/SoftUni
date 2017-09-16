package softuni.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.dto.Export.BranchesExportXmlDto;
import softuni.dto.Export.EmployeeCardExportJsonDto;
import softuni.dto.Export.EmployeeExportJsonDto;
import softuni.dto.Export.TownsExportXmlDto;
import softuni.dto.Import.*;
import softuni.io.JsonParser;
import softuni.io.XmlParser;
import softuni.services.api.*;

import java.util.List;



@Component
public class Terminal implements CommandLineRunner {
    private final JsonParser jsonParser;
    private final XmlParser xmlParser;
    private final EmployeeService employeeService;
    private final ProductService productService;
    private final BranchService branchService;
    private final EmployeeCardService employeeCardService;
    private final TownService townService;

    @Autowired
    public Terminal(JsonParser jsonParser, XmlParser xmlParser, EmployeeService employeeService, ProductService productService, BranchService branchService, EmployeeCardService employeeCardService, TownService townService) {
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.employeeService = employeeService;
        this.productService = productService;
        this.branchService = branchService;
        this.employeeCardService = employeeCardService;
        this.townService = townService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        importTownsJson();
//        importBranchesJson();
//        importEmployeeCardsJson();
//        importProductsXml();
//        importEmployeesXml();
//
//        exportUnusedCardsJson();
//        exportProductiveEmployeesJson();
//        exportTownsXml();
//        exportBranchesXml();
    }

    private void exportBranchesXml() {
        BranchesExportXmlDto branchesDto = this.branchService.getTopBranches();
        this.xmlParser.serialize(branchesDto, "src/main/resources/files/xml/out/top-branches.xml");
    }

    private void exportTownsXml() {
        TownsExportXmlDto townsDto = this.townService.getAllTowns();
        this.xmlParser.serialize(townsDto, "src/main/resources/files/xml/out/towns.xml");
    }

    private void exportProductiveEmployeesJson() {
        List<EmployeeExportJsonDto> employeeDtos = this.employeeService.getAllProductive();
        this.jsonParser.serialize(employeeDtos, "src/main/resources/files/json/out/productive-employees.json");
    }

    private void exportUnusedCardsJson() {
        List<EmployeeCardExportJsonDto> employeeCardDtos = this.employeeCardService.getAllUnused();
        this.jsonParser.serialize(employeeCardDtos, "src/main/resources/files/json/out/free_cards.json");
    }

    private void importEmployeesXml() {
        EmployeesImportXmlDto employeesDto = this.xmlParser
                .deserialize(EmployeesImportXmlDto.class, "/files/xml/in/employees.xml");
        for (EmployeeImportXmlDto employeeDto : employeesDto.getEmployeeImportXmlDtos()) {
            this.employeeService.saveDto(employeeDto);
        }
    }

    private void importProductsXml() {
        ProductsImportXmlDto productsDto = this.xmlParser
                .deserialize(ProductsImportXmlDto.class, "/files/xml/in/products.xml");
        for (ProductImportXmlDto productImportXmlDto : productsDto.getProductImportXmlDtos()) {
            this.productService.saveDto(productImportXmlDto);
        }
    }

    private void importEmployeeCardsJson() {
        EmployeeCardImportJsonDto[] employeeCardDtos = this.jsonParser
                .deserialize(EmployeeCardImportJsonDto[].class, "/files/json/in/employee_cards.json");
        for (EmployeeCardImportJsonDto employeeCardDto : employeeCardDtos) {
            this.employeeCardService.saveDto(employeeCardDto);
        }
    }

    private void importBranchesJson() {
        BranchImportJsonDto[] branchImportDtos = this.jsonParser
                .deserialize(BranchImportJsonDto[].class, "/files/json/in/branches.json");
        for (BranchImportJsonDto branchImportDto : branchImportDtos) {
            this.branchService.saveDto(branchImportDto);
        }
    }

    private void importTownsJson() {
        TownImportJsonDto[] townImportDtos = this.jsonParser
                .deserialize(TownImportJsonDto[].class, "/files/json/in/towns.json");
        for (TownImportJsonDto townImportDto : townImportDtos) {
            this.townService.saveDto(townImportDto);
        }
    }


}
