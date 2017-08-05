package softuni.services.api;


import softuni.dto.JsonImport.CustomerImportJsonDto;
import softuni.dto.JsonQuery.Query1.CustomersByBirthDateDto;
import softuni.dto.JsonQuery.Query5.CustomerSalesDto;
import softuni.entities.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomerDto(CustomerImportJsonDto customerImportJsonDto);

    List<Customer> findAll();

    List<CustomersByBirthDateDto> getAllOrderedByBirthDate();

    List<CustomerSalesDto> getTotalSalesByCustomer();
}
