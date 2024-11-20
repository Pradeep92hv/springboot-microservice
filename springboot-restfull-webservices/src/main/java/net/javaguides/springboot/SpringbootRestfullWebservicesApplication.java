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
The /info Endpoint
If you added any information about the application in
application.properties then we can view it using /info
endpoint
http://localhost:8080/actuator/info


 */
