package com.business;

import com.business.model.Employee;
import com.business.model.Manager;
import com.business.service.BusinessService;
import com.business.exception.BusinessRuleException;

public class Main {
    public static void main(String[] args) {
        BusinessService service = new BusinessService();
        try {
            service.addEmployee(new Employee(1, "Amit", "IT", 40000));
            service.addEmployee(new Employee(2, "Priya", "HR", 35000));
            service.addEmployee(new Manager(3, "Rahul", "IT", 60000, 5));

            System.out.println("ALL EMPLOYEES");
            service.getAllEmployees().forEach(System.out::println);

            System.out.println("\nIT DEPARTMENT");
            service.filterByDepartment("IT").forEach(System.out::println);

            System.out.println("\nSORTED BY SALARY");
            service.sortBySalary().forEach(System.out::println);

            System.out.println("\nDEPARTMENTS");
            System.out.println(service.getDepartments());

            System.out.println("\nTOTAL SALARY");
            System.out.println(service.calculateTotalSalary());
        } catch (BusinessRuleException e) {
            System.out.println("Business error: " + e.getMessage());
        }
    }
}
