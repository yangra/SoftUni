package softuni.services.api;


import softuni.dto.binding.Import.SupplierImportDto;
import softuni.dto.binding.Import.SupplierDto;
import softuni.dto.view.Query3.SupplierLocalDto;

import java.util.List;


public interface SupplierService {
    void saveSupplierDto(SupplierImportDto supplierImportDto);

    List<SupplierDto> findAllSupplierDto();

    List<SupplierLocalDto> getLocalSuppliers();
}
