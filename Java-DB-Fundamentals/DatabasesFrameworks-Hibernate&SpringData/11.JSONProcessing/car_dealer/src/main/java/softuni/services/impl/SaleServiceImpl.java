package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.JsonQuery.Query4.CarPropertiesDto;
import softuni.dto.JsonQuery.Query6.SalePropertiesDto;
import softuni.entities.Part;
import softuni.entities.Sale;
import softuni.io.ModelParser;
import softuni.repositories.SaleRepo;
import softuni.services.api.SaleService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepo saleRepo;

    @Autowired
    public SaleServiceImpl(SaleRepo saleRepo) {
        this.saleRepo = saleRepo;
    }

    @Override
    public void save(Sale sale) {
        this.saleRepo.save(sale);
    }

    @Override
    public List<SalePropertiesDto> getSaleProperties() {
        List<Sale> sales = this.saleRepo.findAll();
        List<SalePropertiesDto> salePropertiesDtos = new ArrayList<>();
        for (Sale sale : sales) {
            SalePropertiesDto salePropertiesDto = ModelParser.getInstance().map(sale,SalePropertiesDto.class);
            CarPropertiesDto carPropertiesDto = ModelParser.getInstance().map(sale.getCar(),CarPropertiesDto.class);
            salePropertiesDto.setCar(carPropertiesDto);
            BigDecimal totalPrice = new BigDecimal("0.00");
            for (Part part : sale.getCar().getParts()) {
                totalPrice = totalPrice.add(part.getPrice());
            }

            salePropertiesDto.setPrice(totalPrice);
            BigDecimal priceDiscounted = totalPrice.multiply(new BigDecimal("1")
                    .subtract(BigDecimal.valueOf(sale.getDiscount()/((double)100))))
                    .stripTrailingZeros();
            salePropertiesDto.setPriceWithDiscount(priceDiscounted);

            salePropertiesDtos.add(salePropertiesDto);
        }
        return salePropertiesDtos;
    }

}
