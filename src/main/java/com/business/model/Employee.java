package com.business.model;

public class Employee extends Person {
    private final EmployeeDetails details;

    public Employee(int id, String name, String department, double salary) {
        super(id, name);
        this.details = new EmployeeDetails(department, salary);
    }

    public String getDepartment() { return details.department(); }
    public double getSalary() { return details.salary(); }

    @Override
    public String getRole() { return "Employee"; }

    @Override
    public String toString() {
        return getId() + " - " + getName() + " | " + getDepartment()
            + " | Salary: " + getSalary();
    }
}
