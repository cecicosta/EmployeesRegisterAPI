package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = com.access.data.EmployeesAccessController.class)
@ComponentScan(basePackageClasses = com.access.data.EmployeeRegistersAccessController.class)
@ComponentScan(basePackageClasses = com.authentication.jwt.LoginController.class)
@ComponentScan(basePackageClasses = hello.Greeting.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}