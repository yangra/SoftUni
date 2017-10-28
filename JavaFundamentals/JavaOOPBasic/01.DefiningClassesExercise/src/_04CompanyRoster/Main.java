package _04CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfEmployee = Integer.parseInt(reader.readLine());

        Map<String,List<Employee>> departments = new HashMap<>();

        for (int i = 0; i < numberOfEmployee; i++) {
            String[] person = reader.readLine().split("\\s+");
            Employee employee = new Employee(person[0], Double.parseDouble(person[1]), person[2], person[3]);
            if(person.length == 5){
                if(person[4].contains("@")){
                    employee.setEmail(person[4]);
                }else{
                    employee.setAge(Integer.parseInt(person[4]));
                }
            }else if(person.length==6){
                employee.setEmail(person[4]);
                employee.setAge(Integer.parseInt(person[5]));
            }

            departments.putIfAbsent(person[3],new ArrayList<>());
            departments.get(person[3]).add(employee);
        }
        StringBuilder builder = new StringBuilder();
        departments.entrySet().stream()
                .sorted((d1,d2)->Double.compare(d2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        d1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1).forEach(d-> {

                    builder.append(String.format("Highest Average Salary: %s\n",d.getKey()));
                    d.getValue().stream()
                            .sorted(Comparator.comparing(Employee::getSalary).reversed())
                            .forEach(builder::append);
                });

        System.out.println(builder.toString());
    }

}
