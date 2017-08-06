package softuni.services.api;


import softuni.dto.view.Query6.SalePropertiesDto;
import softuni.entities.Sale;

import java.util.List;

public interface SaleService {
    void save(Sale sale);

    List<SalePropertiesDto> getSalesProperties();
}
