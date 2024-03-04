package com.ug.employeemongoredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EmployeeMongoRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMongoRedisApplication.class, args);
	}

}
