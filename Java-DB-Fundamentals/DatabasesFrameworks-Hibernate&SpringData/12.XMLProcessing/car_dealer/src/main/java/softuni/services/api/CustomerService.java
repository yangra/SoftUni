package softuni.services.api;


import softuni.dto.binding.Import.CustomerImportDto;
import softuni.dto.view.Query1.CustomerByBirthDateDto;
import softuni.dto.view.Query5.CustomerSalesDto;
import softuni.entities.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomerDto(CustomerImportDto customerImportDto);

    List<Customer> findAll();

    List<CustomerByBirthDateDto> getAllOrderedByBirthDate();

    List<CustomerSalesDto> getTotalSalesByCustomer();
}
