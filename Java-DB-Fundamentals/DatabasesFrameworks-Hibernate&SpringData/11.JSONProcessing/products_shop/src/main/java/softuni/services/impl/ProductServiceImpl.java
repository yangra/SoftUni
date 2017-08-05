package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.binding.Add.ProductAddDto;
import softuni.dto.view.Query1.ProductRangeDto;
import softuni.entities.Product;
import softuni.io.ModelParser;
import softuni.repositories.ProductRepository;
import softuni.services.api.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(ProductAddDto productAddDto) {
        Product product = ModelParser.getInstance().map(productAddDto, Product.class);
        this.productRepository.saveAndFlush(product);
    }

    @Override
    public List<ProductRangeDto> getProductsInPriceRange(BigDecimal lowLimit, BigDecimal highLimit) {
        List<Product> products = this.productRepository.findByPriceBetweenAndBuyerIsNullOrderByPriceAsc(lowLimit, highLimit);
        List<ProductRangeDto> productRangeDtos = new ArrayList<>();
        for (Product product : products) {
            ProductRangeDto productRangeDto = ModelParser.getInstance().map(product, ProductRangeDto.class);
            productRangeDto.setSellerFullName(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());
            productRangeDtos.add(productRangeDto);
        }

        return productRangeDtos;
    }
}
