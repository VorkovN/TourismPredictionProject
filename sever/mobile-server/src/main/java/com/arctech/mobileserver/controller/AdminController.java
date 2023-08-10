package com.arctech.mobileserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String home(){
        return "This is home page, admin";
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello, admin";
    }
}
