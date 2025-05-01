package com.tcs.learning.spring_boot_sonarqube_demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping(value = "/test")
    public String test(){
        return "This is the testing API";
    }
}
