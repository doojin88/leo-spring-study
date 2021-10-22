package com.example.Payroll;

public class EmployeeNotFoundExceptioin extends RuntimeException {
    EmployeeNotFoundExceptioin(Long id) {
        super("Could not find employee" + id);
    }
}
