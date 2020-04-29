package com.amazonconnect.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/amazonConnect")
public class AmazonConnectController {

    @GetMapping("/name")
    public String name(){
        return "HI Jitunu";
    }
}
