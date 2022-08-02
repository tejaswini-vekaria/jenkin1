package com.jenkins.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/hello")
    public String message() {
        return "Hello This is Tejaswini's app deployed on kubernetes";
    }
}
