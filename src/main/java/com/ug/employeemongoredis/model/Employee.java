package com.ug.employeemongoredis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class Employee implements Serializable {

    @Id
    @Field("_id")
    private String id;
    private String name;
    private String designation;
    private boolean active;
    private Date joiningDate;
}
