package com.ug.employeemongoredis.controller;

import com.ug.employeemongoredis.model.Employee;
import com.ug.employeemongoredis.model.request.CreateEmployeeRequest;
import com.ug.employeemongoredis.model.request.UpdateEmployeeRequest;
import com.ug.employeemongoredis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        if (employeeService.getEmployee(updateEmployeeRequest.getId()).isPresent()) {
            Employee updatedEmployee = employeeService.updateEmployee(updateEmployeeRequest);
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") String id) {
        if (employeeService.getEmployee(id).isPresent()) {
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok("Successfully Deleted employee with id: "+id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

