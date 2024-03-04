package com.ug.employeemongoredis.repository;

import com.ug.employeemongoredis.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}