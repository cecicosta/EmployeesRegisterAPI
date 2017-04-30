package com.register.api.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = com.register.api.authentication.SignUpController.class)
@ComponentScan(basePackageClasses = com.register.api.submit.SubmitRegisterController.class)
@ComponentScan(basePackageClasses = com.register.api.access.data.EmployeesAccessController.class)
@ComponentScan(basePackageClasses = com.register.api.access.data.EmployeeRegistersAccessController.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}