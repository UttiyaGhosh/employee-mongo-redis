package com.ug.employeemongoredis.controller;

import com.ug.employeemongoredis.model.CreateEmployeeRequest;
import com.ug.employeemongoredis.model.Employee;
import com.ug.employeemongoredis.model.UpdateEmployeeRequest;
import com.ug.employeemongoredis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        Employee savedEmployee = employeeService.createEmployee(createEmployeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        if (employeeService.exists(updateEmployeeRequest.getId())) {
            Employee updatedEmployee = employeeService.updateEmployee(updateEmployeeRequest);
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

