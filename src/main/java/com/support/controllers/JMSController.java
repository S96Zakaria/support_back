package com.support.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/JMS")
public class JMSController {

    @GetMapping("/")
    private String test(){


        return "test";
    }
}
