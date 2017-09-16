package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.Export.EmployeeExportJsonDto;
import softuni.dto.Import.EmployeeImportXmlDto;
import softuni.entities.Branch;
import softuni.entities.Employee;
import softuni.entities.EmployeeCard;
import softuni.repositories.BranchRepository;
import softuni.repositories.EmployeeCardRepository;
import softuni.repositories.EmployeeRepository;
import softuni.services.api.EmployeeService;
import softuni.utils.DataValidator;
import softuni.utils.ModelParser;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeCardRepository employeeCardRepository;
    private final BranchRepository branchRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeCardRepository employeeCardRepository, BranchRepository branchRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeCardRepository = employeeCardRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public void saveDto(EmployeeImportXmlDto employeeDto) {
        if (DataValidator.validate(employeeDto)) {
            List<Employee> employees = this.employeeRepository.findAll();
            for (Employee emp : employees) {
                if (emp.getEmployeeCard().getNumber().equals(employeeDto.getCard())) {
                    System.out.println("Error: Invalid data. Employee card number must be unique");
                    return;
                }
            }
            Employee employee = ModelParser.getInstance().map(employeeDto, Employee.class);

            Branch branch = this.branchRepository.findByName(employeeDto.getBranch());
            EmployeeCard employeeCard = this.employeeCardRepository.findByNumber(employeeDto.getCard());

            if (branch != null) {
                employee.setBranch(branch);
            } else {
                System.out.println("Error: Invalid data. No such branch.");
                return;
            }
            if (employeeCard != null) {
                employee.setEmployeeCard(employeeCard);
            } else {
                System.out.println("Error: Invalid data. No such employee card.");
                return;
            }

            this.employeeRepository.saveAndFlush(employee);
            System.out.printf("Successfully imported Employee %s %s\n", employee.getFirstName(), employee.getLastName());
        } else {
            System.out.println("Error: Invalid data.");
        }
    }

    @Override
    public List<EmployeeExportJsonDto> getAllProductive() {
        List<Employee> employees = this.employeeRepository.findAllProductive();
        List<EmployeeExportJsonDto> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeExportJsonDto employeeDto = ModelParser.getInstance().map(employee, EmployeeExportJsonDto.class);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }
}
