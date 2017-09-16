package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.Import.ProductImportXmlDto;
import softuni.entities.Branch;
import softuni.entities.Product;
import softuni.repositories.BranchRepository;
import softuni.repositories.ProductRepository;
import softuni.services.api.ProductService;
import softuni.utils.DataValidator;
import softuni.utils.ModelParser;

import javax.transaction.Transactional;

/**
 * Created by Yana on 8/13/2017.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, BranchRepository branchRepository) {
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public void saveDto(ProductImportXmlDto productDto) {
        if (DataValidator.validate(productDto)) {
            Product product = ModelParser.getInstance().map(productDto, Product.class);
            Branch branch = this.branchRepository.findByName(productDto.getBranch());
            if (branch != null) {
                product.setBranch(branch);
            }else{
                System.out.println("Error: Invalid data. No such branch");
                return;
            }

            this.productRepository.saveAndFlush(product);
            System.out.printf("Successfully imported Product %s\n", product.getName());
        } else {
            System.out.println("Error: Invalid data.");
        }
    }
}
