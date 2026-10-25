package com.business.model;

public record EmployeeDetails(String department, double salary) {
    public EmployeeDetails {
        if (department == null || department.isBlank())
            throw new IllegalArgumentException("Department cannot be empty");
        if (!Double.isFinite(salary) || salary < 0)
            throw new IllegalArgumentException("Salary must be finite and non-negative");
    }
}
