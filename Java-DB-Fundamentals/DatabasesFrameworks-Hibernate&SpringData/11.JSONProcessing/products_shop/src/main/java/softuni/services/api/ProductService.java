package softuni.services.api;


import softuni.dto.binding.Add.ProductAddDto;
import softuni.dto.view.Query1.ProductRangeDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void save(ProductAddDto productAddDto);

    List<ProductRangeDto> getProductsInPriceRange(BigDecimal lowLimit, BigDecimal highLimit);
}
