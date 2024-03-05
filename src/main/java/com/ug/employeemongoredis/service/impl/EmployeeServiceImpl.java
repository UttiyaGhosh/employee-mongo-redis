package com.ug.employeemongoredis.service.impl;

import com.ug.employeemongoredis.model.Employee;
import com.ug.employeemongoredis.model.request.CreateEmployeeRequest;
import com.ug.employeemongoredis.model.request.UpdateEmployeeRequest;
import com.ug.employeemongoredis.repository.EmployeeRepository;
import com.ug.employeemongoredis.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final String REDIS_REGION = "employee";
    @Autowired private EmployeeRepository employeeRepository;

    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    @CachePut(value = REDIS_REGION, key = "#createEmployeeRequest.id")
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
    @Cacheable(value = REDIS_REGION, key = "#id")
    public Optional<Employee> getEmployee(String id) {
        logger.info("Checking db for employee details with id: "+id);
        return employeeRepository.findById(id);
    }

    @Override
    @CachePut(value = REDIS_REGION, key = "#createEmployeeRequest.id")
    public Employee updateEmployee(UpdateEmployeeRequest updateEmployeeRequest) {
        return employeeRepository.updateEmployee(Employee.builder()
                .id(updateEmployeeRequest.getId().toString())
                .name(updateEmployeeRequest.getName())
                .designation(updateEmployeeRequest.getDesignation())
                .build());
    }

    @Override
    @CacheEvict(value = REDIS_REGION, key = "#id")
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}

