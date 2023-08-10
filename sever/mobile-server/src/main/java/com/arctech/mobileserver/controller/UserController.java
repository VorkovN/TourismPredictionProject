package com.arctech.mobileserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public String home(){
        return "This is home page, user";
    }
    @GetMapping("/hello")
    public String getRequest(){
        return "welcome, user";
    }
}
