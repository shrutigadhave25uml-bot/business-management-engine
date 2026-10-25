package com.business.service;

import com.business.model.Employee;
import com.business.exception.BusinessRuleException;
import com.business.exception.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class BusinessService {
    private final List<Employee> employees = new ArrayList<>();
    private final Set<String> departments = new TreeSet<>();
    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    public void addEmployee(Employee employee) throws BusinessRuleException {
        Objects.requireNonNull(employee, "Employee cannot be null");
        if (employeeMap.containsKey(employee.getId()))
            throw new BusinessRuleException("Employee ID already exists");

        employees.add(employee);
        employeeMap.put(employee.getId(), employee);
        departments.add(employee.getDepartment());
    }

    public Employee findById(int id) {
        Employee employee = employeeMap.get(id);
        if (employee == null) throw new EmployeeNotFoundException("Employee not found: " + id);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return Collections.unmodifiableList(new ArrayList<>(employees));
    }

    public Set<String> getDepartments() {
        return Collections.unmodifiableSet(new TreeSet<>(departments));
    }

    public List<Employee> sortBySalary() {
        return employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary))
            .collect(Collectors.toList());
    }

    public List<Employee> filterByDepartment(String department) {
        return employees.stream()
            .filter(e -> e.getDepartment().equalsIgnoreCase(department))
            .collect(Collectors.toList());
    }

    public double calculateTotalSalary() {
        return employees.stream().mapToDouble(Employee::getSalary).sum();
    }
}
