package com.ug.employeemongoredis.service;

import com.ug.employeemongoredis.model.Employee;
import com.ug.employeemongoredis.model.request.CreateEmployeeRequest;
import com.ug.employeemongoredis.model.request.UpdateEmployeeRequest;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee createEmployee(CreateEmployeeRequest createEmployeeRequest);

    Optional<Employee> getEmployee(String id);

    Employee updateEmployee(UpdateEmployeeRequest updateEmployeeRequest);

    void deleteEmployee(String id);
}