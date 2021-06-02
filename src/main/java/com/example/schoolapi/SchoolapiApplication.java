package com.example.schoolapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication

public class SchoolapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolapiApplication.class, args);
	}

}
