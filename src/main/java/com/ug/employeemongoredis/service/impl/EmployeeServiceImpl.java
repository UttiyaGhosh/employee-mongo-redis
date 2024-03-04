package com.ug.employeemongoredis.service.impl;

import com.ug.employeemongoredis.model.CreateEmployeeRequest;
import com.ug.employeemongoredis.model.Employee;
import com.ug.employeemongoredis.model.UpdateEmployeeRequest;
import com.ug.employeemongoredis.repository.EmployeeRepository;
import com.ug.employeemongoredis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        final UUID employeeId = UUID.randomUUID();

        return employeeRepository.save(
                Employee.builder()
                        .id(employeeId.toString())
                        .name(createEmployeeRequest.getName())
                        .designation(createEmployeeRequest.getDesignation())
                        .active(true)
                        .joiningDate(new Date())
                        .build());
    }
    @Override
    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(UpdateEmployeeRequest updateEmployeeRequest) {
        return employeeRepository.updateEmployee(Employee.builder()
                .id(updateEmployeeRequest.getId().toString())
                .name(updateEmployeeRequest.getName())
                .designation(updateEmployeeRequest.getDesignation())
                .build());
    }

    @Override
    public boolean exists(String id){
        return employeeRepository.existsById(id);
    }
}

