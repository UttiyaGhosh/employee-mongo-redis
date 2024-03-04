package com.ug.employeemongoredis.service;

import com.ug.employeemongoredis.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Optional<Employee> getEmployeeById(String id);

    Employee updateEmployee(String id, Employee employee);

    void deleteEmployee(String id);
}