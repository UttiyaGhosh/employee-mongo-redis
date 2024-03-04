package com.ug.employeemongoredis.service;

import com.ug.employeemongoredis.model.CreateEmployeeRequest;
import com.ug.employeemongoredis.model.Employee;
import com.ug.employeemongoredis.model.UpdateEmployeeRequest;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee createEmployee(CreateEmployeeRequest createEmployeeRequest);

    Optional<Employee> getEmployeeById(String id);

    Employee updateEmployee(UpdateEmployeeRequest updateEmployeeRequest);

    boolean exists(String id);
}