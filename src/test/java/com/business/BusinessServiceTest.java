package com.business;

import com.business.model.Employee;
import com.business.model.Manager;
import com.business.service.BusinessService;
import com.business.exception.BusinessRuleException;
import com.business.exception.EmployeeNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessServiceTest {
    private BusinessService service;

    @BeforeEach
    void setUp() throws BusinessRuleException {
        service = new BusinessService();
        service.addEmployee(new Employee(1, "Amit", "IT", 40000));
        service.addEmployee(new Employee(2, "Priya", "HR", 35000));
    }

    @Test
    void shouldAddEmployee() {
        assertEquals(2, service.getAllEmployees().size());
        assertEquals("Amit", service.findById(1).getName());
    }

    @Test
    void shouldRejectDuplicateId() {
        Employee duplicate = new Employee(1, "Rahul", "IT", 50000);
        assertThrows(BusinessRuleException.class, () -> service.addEmployee(duplicate));
    }

    @Test
    void shouldThrowWhenEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class, () -> service.findById(99));
    }

    @Test
    void shouldFilterByDepartment() {
        assertEquals(1, service.filterByDepartment("IT").size());
    }

    @Test
    void shouldSortEmployeesBySalary() {
        assertEquals("Priya", service.sortBySalary().get(0).getName());
    }

    @Test
    void shouldCalculateTotalSalary() {
        assertEquals(75000.0, service.calculateTotalSalary());
    }

    @Test
    void shouldSupportManagerInheritance() {
        Manager manager = new Manager(3, "Rahul", "IT", 60000, 5);
        assertEquals("Manager", manager.getRole());
        assertEquals(5, manager.getTeamSize());
    }
}
