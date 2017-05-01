package com.register.api.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.register.api.events.CommandBus;

@SpringBootApplication
@ComponentScan(basePackageClasses = com.register.api.submit.SignUpController.class)
@ComponentScan(basePackageClasses = com.register.api.submit.SubmitRegisterController.class)
@ComponentScan(basePackageClasses = com.register.api.access.data.EmployeesAccessController.class)
@ComponentScan(basePackageClasses = com.register.api.access.data.EmployeeRegistersAccessController.class)
public class Application {

    public static void main(String[] args) {
    	CommandBus cb = new CommandBus();
    	cb.start();
        SpringApplication.run(Application.class, args);
        cb.interrupt();
    }
}