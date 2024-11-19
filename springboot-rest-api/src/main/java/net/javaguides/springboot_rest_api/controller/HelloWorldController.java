package net.javaguides.springboot_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody  // to convert java obj to json i.e retured into http response
@RestController
public class HelloWorldController {

    // HTTP GET REQUEST
    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String HelloWorld(){
        return  "Hello World!";
    }
}
