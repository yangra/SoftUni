package softuni.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.dto.binding.CategoryDto;
import softuni.dto.binding.UserDto;
import softuni.dto.binding.Add.CategoryAddDto;
import softuni.dto.binding.Add.ProductAddDto;
import softuni.dto.binding.Add.UserAddDto;
import softuni.dto.view.Query3.CategoryViewDto;
import softuni.dto.view.Query1.ProductRangeDto;
import softuni.dto.view.Query2.UserSoldProductsDto;
import softuni.dto.view.Query4.UsersListDto;
import softuni.io.JsonParser;
import softuni.services.api.CategoryService;
import softuni.services.api.ProductService;
import softuni.services.api.UserService;

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


    @Autowired
    public Terminal(UserService userService, ProductService productService, CategoryService categoryService, JsonParser jsonParser) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.jsonParser = jsonParser;
    }

    @Override
    public void run(String... strings) throws Exception {
//        importUsers();
//        importCategories();
//        importProducts();

//        exportProductsInRange();
//        exportUsersBySoldProducts();
//        exportCategoriesByProductsCount();
        exportUsersAndTheirSoldProducts();


    }

    private void exportUsersAndTheirSoldProducts() {
        UsersListDto usersListDto = this.userService.getUsersBySoldProductsCount();
        this.jsonParser.serialize(usersListDto,"/src/main/resources/files/out/usersBySoldProductCount.json");
    }

    private void exportCategoriesByProductsCount() {
        List<CategoryViewDto> categoryViewDtos = this.categoryService.getAllCategoriesByProductCount();
        this.jsonParser.serialize(categoryViewDtos,"/src/main/resources/files/out/categoriesByProductCount.json");
    }

    private void exportUsersBySoldProducts() {
        List<UserSoldProductsDto> userSoldProductsDtos = this.userService.getUserSoldProducts();
        this.jsonParser.serialize(userSoldProductsDtos, "/src/main/resources/files/out/userSoldProducts.json");
    }

    private void exportProductsInRange() {
        List<ProductRangeDto> productRangeDtos = this.productService
                .getProductsInPriceRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
        this.jsonParser.serialize(productRangeDtos,"/src/main/resources/files/out/productsInRange.json");
    }

    private void importProducts() {
        Random random = new Random();
        int count = 0;
        List<UserDto> users = this.userService.findAll();
        List<CategoryDto> categories = this.categoryService.findAll();
        ProductAddDto[] productAddDtos = jsonParser.deserialize(ProductAddDto[].class,"/files/in/products.json");
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
        CategoryAddDto[] categoryAddDtos = jsonParser.deserialize(CategoryAddDto[].class,"/files/in/categories.json");
        for (CategoryAddDto categoryAddDto : categoryAddDtos) {
            this.categoryService.save(categoryAddDto);
        }
    }

    private void importUsers() {
        UserAddDto[] users = this.jsonParser.deserialize(UserAddDto[].class, "/files/in/users.json");
        for (UserAddDto user : users) {
            this.userService.save(user);
        }
    }
}
