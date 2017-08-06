package softuni.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.dto.binding.CategoryDto;
import softuni.dto.binding.UserDto;
import softuni.dto.binding.Add.CategoryAddDto;
import softuni.dto.binding.Add.ProductAddDto;
import softuni.dto.binding.Add.UserAddDto;
import softuni.dto.binding.XMLDtos.CategoryImportXMLDto;
import softuni.dto.binding.XMLDtos.ProductImportXMLDto;
import softuni.dto.binding.XMLDtos.UsersImportXMLDto;
import softuni.dto.view.Query1.ProductsRangeXMLDto;
import softuni.dto.view.Query2.UsersSoldProductXMLDto;
import softuni.dto.view.Query3.CategoriesViewXMLDto;
import softuni.dto.view.Query3.CategoryViewDto;
import softuni.dto.view.Query1.ProductRangeDto;
import softuni.dto.view.Query2.UserSoldProductsDto;
import softuni.dto.view.Query4.UsersListDto;
import softuni.io.JsonParser;
import softuni.io.XMLParser;
import softuni.services.api.CategoryService;
import softuni.services.api.ProductService;
import softuni.services.api.UserService;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Component
public class Terminal implements CommandLineRunner {

    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final JsonParser jsonParser;
    private final XMLParser xmlParser;

    @Autowired
    public Terminal(UserService userService, ProductService productService, CategoryService categoryService, JsonParser jsonParser, XMLParser xmlParser) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... strings) throws Exception {
//        ######################## JSON ###################
//        importUsers();
//        importCategories();
//        importProducts();

//        exportProductsInRange();
//        exportUsersBySoldProducts();
//        exportCategoriesByProductsCount();
//        exportUsersAndTheirSoldProducts();

//        ######################### XML #######################
//        importXMLUsers();
//        importXMLCategories();
//        importXMLProducts();

//        exportProductsInRangeXML();
//        exportUsersWithSoldProductsXML();
//        exportCategoriesWithProductsXML();
//        exportUsersByCountOfSoldProductsXML();

    }

    private void exportUsersByCountOfSoldProductsXML() {
        UsersListDto users = this.userService.getUsersBySoldProductsCount();
        try {
            this.xmlParser.serialize(users,"src/main/resources/files/xml/out/UsersByCountOfProducts.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportCategoriesWithProductsXML() {
        CategoriesViewXMLDto categoriesViewXMLDto =  new CategoriesViewXMLDto();
        List<CategoryViewDto> categories = this.categoryService.getAllCategoriesByProductCount();
        categoriesViewXMLDto.setCategoryViewDtos(categories);
        try {
            this.xmlParser.serialize(categoriesViewXMLDto,"src/main/resources/files/xml/out/CategoriesWithProducts.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportUsersWithSoldProductsXML() {
        UsersSoldProductXMLDto usersSoldProductXMLDto = new UsersSoldProductXMLDto();
        List<UserSoldProductsDto> usersWithProducts = this.userService.getUserSoldProducts();
        usersSoldProductXMLDto.setUserSoldProductsDtos(usersWithProducts);
        try {
            this.xmlParser.serialize(usersSoldProductXMLDto,"src/main/resources/files/xml/out/UsersWithSoldProducts.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void exportProductsInRangeXML() {
        ProductsRangeXMLDto productsRangeXMLDto = new ProductsRangeXMLDto();
        List<ProductRangeDto> productRangeDtos = this.productService
                .getProductsInPriceRange(BigDecimal.valueOf(500),BigDecimal.valueOf(1000));
        productsRangeXMLDto.setProductRangeDtos(productRangeDtos);
        try {
            this.xmlParser.serialize(productsRangeXMLDto,"src/main/resources/files/xml/out/ProductsInRange.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importXMLProducts() {
        Random random = new Random();
        int count = 0;
        List<UserDto> users = this.userService.findAll();
        List<CategoryDto> categories = this.categoryService.findAll();
        try {

            ProductImportXMLDto products = xmlParser.deserialize(ProductImportXMLDto.class, "/files/xml/in/products.xml");

            for (ProductAddDto productAddDto : products.getProductAddDtos()) {
                Set<CategoryDto> categoryDtoSet = new HashSet<>();
                UserDto seller = users.get(random.nextInt(users.size()));
                UserDto buyer = users.get(random.nextInt(users.size()));

                if(buyer.getId().equals(seller.getId())|| count%10 == 0){
                    buyer = null;
                }

                int limit = random.nextInt(10);
                for (int i = -1; i < limit ; i++) {
                    categoryDtoSet.add(categories.get(random.nextInt(categories.size())));
                }

                productAddDto.setBuyer(buyer);
                productAddDto.setSeller(seller);
                productAddDto.setCategories(categoryDtoSet);
                this.productService.save(productAddDto);
                count++;
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importXMLCategories() {
        try {
            CategoryImportXMLDto categories = this.xmlParser.deserialize(CategoryImportXMLDto.class,"/files/xml/in/categories.xml");
            for (CategoryAddDto categoryAddDto : categories.getCategories()) {
                this.categoryService.save(categoryAddDto);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importXMLUsers() {
        try {
            UsersImportXMLDto users = this.xmlParser.deserialize(UsersImportXMLDto.class,"/files/xml/in/users.xml");
            for (UserAddDto userAddDto : users.getUserAddDtos()) {
                this.userService.save(userAddDto);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportUsersAndTheirSoldProducts() {
        UsersListDto usersListDto = this.userService.getUsersBySoldProductsCount();
        this.jsonParser.serialize(usersListDto,"/src/main/resources/files/json/out/usersBySoldProductCount.json");
    }

    private void exportCategoriesByProductsCount() {
        List<CategoryViewDto> categoryViewDtos = this.categoryService.getAllCategoriesByProductCount();
        this.jsonParser.serialize(categoryViewDtos,"/src/main/resources/files/json/out/categoriesByProductCount.json");
    }

    private void exportUsersBySoldProducts() {
        List<UserSoldProductsDto> userSoldProductsDtos = this.userService.getUserSoldProducts();
        this.jsonParser.serialize(userSoldProductsDtos, "/src/main/resources/files/json/out/userSoldProducts.json");
    }

    private void exportProductsInRange() {
        List<ProductRangeDto> productRangeDtos = this.productService
                .getProductsInPriceRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
        this.jsonParser.serialize(productRangeDtos,"/src/main/resources/files/json/out/productsInRange.json");
    }

    private void importProducts() {
        Random random = new Random();
        int count = 0;
        List<UserDto> users = this.userService.findAll();
        List<CategoryDto> categories = this.categoryService.findAll();
        ProductAddDto[] productAddDtos = jsonParser.deserialize(ProductAddDto[].class, "/files/json/in/products.json");
        for (ProductAddDto productAddDto : productAddDtos) {
            Set<CategoryDto> categoryDtoSet = new HashSet<>();
            UserDto seller = users.get(random.nextInt(users.size()));
            UserDto buyer = users.get(random.nextInt(users.size()));

            if(buyer.getId().equals(seller.getId())|| count%10 == 0){
                buyer = null;
            }

            int limit = random.nextInt(10);
            for (int i = -1; i < limit ; i++) {
                categoryDtoSet.add(categories.get(random.nextInt(categories.size())));
            }

            productAddDto.setBuyer(buyer);
            productAddDto.setSeller(seller);
            productAddDto.setCategories(categoryDtoSet);
            this.productService.save(productAddDto);
            count++;
        }
    }

    private void importCategories() {
        CategoryAddDto[] categoryAddDtos = jsonParser.deserialize(CategoryAddDto[].class, "/files/json/in/categories.json");
        for (CategoryAddDto categoryAddDto : categoryAddDtos) {
            this.categoryService.save(categoryAddDto);
        }
    }

    private void importUsers() {
        UserAddDto[] users = this.jsonParser.deserialize(UserAddDto[].class, "/files/json/in/users.json");
        for (UserAddDto user : users) {
            this.userService.save(user);
        }
    }
}
