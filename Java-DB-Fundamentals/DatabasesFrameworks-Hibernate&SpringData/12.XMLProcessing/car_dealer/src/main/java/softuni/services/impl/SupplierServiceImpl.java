package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.binding.Import.SupplierImportDto;
import softuni.dto.binding.Import.SupplierDto;
import softuni.dto.view.Query3.SupplierLocalDto;
import softuni.entities.Supplier;
import softuni.io.ModelParser;
import softuni.repositories.SupplierRepo;
import softuni.services.api.SupplierService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepo supplierRepo;

    @Autowired
    public SupplierServiceImpl(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }


    @Override
    public void saveSupplierDto(SupplierImportDto supplierImportDto) {
        Supplier supplier = ModelParser.getInstance().map(supplierImportDto,Supplier.class);
        this.supplierRepo.saveAndFlush(supplier);
    }

    @Override
    public List<SupplierDto> findAllSupplierDto() {
        List<Supplier> suppliers = this.supplierRepo.findAll();
        List<SupplierDto> supplierDtos = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            SupplierDto supplierDto = ModelParser.getInstance().map(supplier,SupplierDto.class);
            supplierDtos.add(supplierDto);
        }
        return supplierDtos;
    }

    @Override
    public List<SupplierLocalDto> getLocalSuppliers() {
        List<Supplier> suppliers = this.supplierRepo.findByImporterFalse();
        List<SupplierLocalDto> supplierLocalDtos = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            SupplierLocalDto supplierLocalDto = ModelParser.getInstance().map(supplier,SupplierLocalDto.class);
            supplierLocalDto.setPartsCount(supplier.getParts().size());
            supplierLocalDtos.add(supplierLocalDto);
        }
        return supplierLocalDtos;
    }
}
