package softuni.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.JsonImport.CustomerImportJsonDto;
import softuni.dto.JsonQuery.Query1.CustomersByBirthDateDto;
import softuni.dto.JsonQuery.Query5.CustomerSalesDto;
import softuni.entities.Customer;
import softuni.entities.Part;
import softuni.entities.Sale;
import softuni.io.ModelParser;
import softuni.repositories.CustomerRepo;
import softuni.services.api.CustomerService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public void saveCustomerDto(CustomerImportJsonDto customerImportJsonDto) {
        Customer customer = ModelParser.getInstance().map(customerImportJsonDto,Customer.class);
        this.customerRepo.saveAndFlush(customer);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }

    @Override
    public List<CustomersByBirthDateDto> getAllOrderedByBirthDate() {
        List<Customer> customers = this.customerRepo.findAllByOrderByBirthDateAscYoungDriverAsc();
        List<CustomersByBirthDateDto> customersByBirthDateDtos = new ArrayList<>();
        for (Customer customer : customers) {
            CustomersByBirthDateDto customersByBirthDateDto = ModelParser.getInstance().map(customer,CustomersByBirthDateDto.class);
            customersByBirthDateDtos.add(customersByBirthDateDto);
        }

        return customersByBirthDateDtos;
    }

    @Override
    public List<CustomerSalesDto> getTotalSalesByCustomer() {
        List<Customer> customersSales = this.customerRepo.findTotalSalesByCustomer();
        List<CustomerSalesDto> customerSalesDtos = new ArrayList<>();
        for (Customer customersSale : customersSales) {
            CustomerSalesDto customerSalesDto = new CustomerSalesDto();
            customerSalesDto.setFullName(customersSale.getName());
            customerSalesDto.setBoughtCars(customersSale.getSales().size());

            BigDecimal totalPrice = new BigDecimal("0.00");
            for (Sale sale : customersSale.getSales()) {
                for (Part part : sale.getCar().getParts()) {
                   totalPrice = totalPrice.add(part.getPrice());
                }
            }

            customerSalesDto.setSpentMoney(totalPrice);
            customerSalesDtos.add(customerSalesDto);
        }

        return customerSalesDtos.stream()
                .sorted((a,b)->{
                    int result = b.getSpentMoney().compareTo(a.getSpentMoney());
                    if(result==0){
                        result =  b.getBoughtCars().compareTo(a.getBoughtCars());
                    }
                   return result;
                })
                .collect(Collectors.toList());


    }
}
