package softuni.services.api;


import softuni.dto.JsonImport.SupplierImportJsonDto;
import softuni.dto.JsonImport.SupplierDto;
import softuni.dto.JsonQuery.Query3.SupplierLocalDto;

import java.util.List;


public interface SupplierService {
    void saveSupplierDto(SupplierImportJsonDto supplierImportJsonDto);

    List<SupplierDto> findAllSupplierDto();

    List<SupplierLocalDto> getLocalSuppliers();
}
