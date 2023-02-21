package net.javaguides.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// need both of these annotations
//@Controller // makes Java class Spring MVC controller
//@ResponseBody // tells controller that object returned is automatically serialized into JSON and passed back into the HttpResponse object
@RestController // combines both @Controller and @ResponseBody annotations
public class HelloWorldController {

    // HTTP GET Request
    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

}
