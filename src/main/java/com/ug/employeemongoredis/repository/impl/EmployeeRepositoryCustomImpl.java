package com.ug.employeemongoredis.repository.impl;

import com.ug.employeemongoredis.model.Employee;
import com.ug.employeemongoredis.repository.EmployeeRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

    @Autowired private MongoTemplate mongoTemplate;
    @Override
    public Employee updateEmployee(Employee employee) {
        Query query = new Query(Criteria.where("_id").is(employee.getId()));

        Update update = new Update();
        update.set("name", employee.getName());
        update.set("designation", employee.getDesignation());

        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true);

        return mongoTemplate.findAndModify(query, update, options, Employee.class);
    }
}
