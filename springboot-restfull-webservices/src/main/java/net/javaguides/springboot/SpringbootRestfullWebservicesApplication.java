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

4)  The /conditions Endpoint
The /conditions endpoint shows the auto
conguration report, categorised into pasitiveMatches
and negativeMatche
http://localhost:8080/actuator/conditions

5)  The /mappings Endpoint
The /mappings endpoint shows all the
@RequestMapping paths declared in the application
 This is very helpful for checking which request path
will be handled by which controller method
http://localhost:8080/actuator/mappings

6)  The /configprops Endpoint
The /congprops endpoint offers all the conguration
properties defined by @CongurationProperties bean,
including your conguration properties defined in the
application.properties or YAML les
http://localhost:8080/actuator/congprops

7) The /metrics Endpoint
The /metrics endpoint shows various metrics about
the current application such as how much memory it
is using, how much memory is free, the size of the
heap used, the number of threads used, and so on
http://localhost:8080/actuator/metrics

8) The /env Endpoint
The /env endpoint exposes all the properties from the
Spring’s CongurableEnvironment interface, such as
a list of active proles, application properties, system
environment variables and so on
http://localhost:8080/actuator/env

9) The /threaddump Endpoint
Using /threaddumb endpoint, you can view your
application’s thread dumb with running threads
details and JVM stack trace
http://localhost:8080/actuator/threaddump


 */
