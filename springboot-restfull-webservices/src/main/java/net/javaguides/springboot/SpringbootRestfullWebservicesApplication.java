package net.javaguides.springboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootRestfullWebservicesApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfullWebservicesApplication.class, args);
		System.out.println("hello");

	}

}


/*
1) The /info Endpoint
If you added any information about the application in
application.properties then we can view it using /info
endpoint
http://localhost:8080/actuator/info


2) The /health Endpoint
The /health endpoint shows the health of the
application, including the disk space, databases and
more
http://localhost:8080/actuator/health

3) The /beans Endpoint
The /beans endpoint shows all the beans registered in
your application, including the beans you explicitly
congured and those auto congured by Spring Boot
http://localhost:8080/actuator/beans


 */
