package com.amazonconnect.api.service;


import org.springframework.stereotype.Service;


public interface AmazonConnectService {
    String listUserUsingAPI();
    String listUserUsingSdk() throws Exception;
}