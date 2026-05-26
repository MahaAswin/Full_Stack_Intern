package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.CourseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
//@ResponseBody
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World!!";
    }

    private final Environment environment;

    @Value("EduBackend")
    private String name;

    public HelloWorldController (Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/env")
    public String GetEnvironmentalVariables(){
        String port=environment.getProperty("server.port");
        return "App Name :"+ name +"<br>port :"+port;
    }

}
