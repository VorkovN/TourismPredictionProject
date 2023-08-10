package com.arctech.mobileserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objects")
public class ObjectOwnerController {
    @GetMapping
    public String home(){
        return "This is home page owner object";
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello, object owner!";
    }
}
