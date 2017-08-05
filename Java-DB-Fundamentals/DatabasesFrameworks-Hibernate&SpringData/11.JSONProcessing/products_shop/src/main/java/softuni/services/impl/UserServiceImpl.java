package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.binding.UserDto;
import softuni.dto.binding.Add.UserAddDto;
import softuni.dto.view.Query2.UserSoldProductsDto;
import softuni.dto.view.Query4.ProductListDto;
import softuni.dto.view.Query4.ProductsNameAndPriceDto;
import softuni.dto.view.Query4.UsersListDto;
import softuni.dto.view.Query4.UsersProductsDto;
import softuni.entities.Product;
import softuni.entities.User;
import softuni.io.ModelParser;
import softuni.repositories.ProductRepository;
import softuni.repositories.UserRepository;
import softuni.services.api.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void save(UserAddDto userAddDto) {
        User user = ModelParser.getInstance().map(userAddDto, User.class);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = ModelParser.getInstance().map(user, UserDto.class);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public List<UserSoldProductsDto> getUserSoldProducts() {
        List<User> users = this.userRepository.findBySoldProducts();
        List<UserSoldProductsDto> userSoldProductsDtos = new ArrayList<>();

        for (User user : users) {
            List<Product> delete = new ArrayList<>();
            for (Product product : user.getSoldProducts()) {
                if(product.getBuyer() == null){
                    delete.add(product);
                }
            }
            user.getSoldProducts().removeAll(delete);
            UserSoldProductsDto userSoldProductsDto = ModelParser.getInstance().map(user, UserSoldProductsDto.class);
            userSoldProductsDtos.add(userSoldProductsDto);
        }

        return userSoldProductsDtos;
    }

    @Override
    public UsersListDto getUsersBySoldProductsCount() {
        List<User> users = this.userRepository.findBySoldProductsCount();
        UsersListDto usersListDto = new UsersListDto();
        usersListDto.setUsersCount(users.size());
        List<UsersProductsDto> usersProductsDtos = new ArrayList<>();
        for (User user : users) {
            UsersProductsDto usersProductsDto = ModelParser.getInstance().map(user, UsersProductsDto.class);
            ProductListDto productListDto = usersProductsDto.getSoldProducts();
            List<Product> products = this.productRepository.findSoldProductsByUserId(user.getId());
            productListDto.setCount(products.size());
            List<ProductsNameAndPriceDto> productsNameAndPriceDtos = new ArrayList<>();
            for (Product product : products) {
                ProductsNameAndPriceDto productsNameAndPriceDto = ModelParser.getInstance().map(product, ProductsNameAndPriceDto.class);
                productsNameAndPriceDtos.add(productsNameAndPriceDto);
            }

            productListDto.setProducts(productsNameAndPriceDtos);
            usersProductsDtos.add(usersProductsDto);
        }

        usersListDto.setUsers(usersProductsDtos);
        return usersListDto;
    }
}
