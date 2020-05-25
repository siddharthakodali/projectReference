package com.projectreference.reference.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHi() {

        return "Hi";
    }

    @RequestMapping("/")
    public String entryMapping(){
        return "WELCOME TO THE APPLICATION";
    }

    @GetMapping("/user")
    public String userRole(){
        return "Welcome user to the applicartion";
    }

    @GetMapping("/admin")
    public String adminRole(){
        return "Welcome Admin to the application";
    }
}
