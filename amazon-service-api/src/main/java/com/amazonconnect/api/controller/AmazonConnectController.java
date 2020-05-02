package com.amazonconnect.api.controller;

import com.amazonconnect.api.service.AmazonConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON;


@RestController
@RequestMapping("/amazonConnect")
public class AmazonConnectController {

    @Autowired
    public AmazonConnectService amazonConnectService;

    @GetMapping("/name")
    public String name(){
        return "HI Jitunu";
    }



    @GetMapping("/users")
    public String listOfUser() throws  Exception{
        return amazonConnectService.listUserUsingSdk();
    }



}
