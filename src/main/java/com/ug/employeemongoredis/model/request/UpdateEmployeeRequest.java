package com.ug.employeemongoredis.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {

    private String id;
    private String name;
    private String designation;
}
