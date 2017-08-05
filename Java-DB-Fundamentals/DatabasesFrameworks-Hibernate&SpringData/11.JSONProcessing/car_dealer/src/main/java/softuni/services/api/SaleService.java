package softuni.services.api;


import softuni.dto.JsonQuery.Query6.SalePropertiesDto;
import softuni.entities.Sale;

import java.util.List;

public interface SaleService {
    void save(Sale sale);

    List<SalePropertiesDto> getSaleProperties();
}
