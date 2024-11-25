package net.javaguides.department_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
		System.out.println("Department Service");
	}
	// go to maven , select the service, -> lifecycle -> package, then open terminal go to required dir and run below command
//java -jar -Dserver.port=8083 target/department-service-0.0.1-SNAPSHOT.jar
	//http://localhost:8080/api/departments/cse01
}
