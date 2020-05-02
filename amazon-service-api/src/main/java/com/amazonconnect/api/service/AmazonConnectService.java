package com.amazonconnect.api.service;


import org.springframework.stereotype.Service;


public interface AmazonConnectService {
    String listUser();
    String listUserUsingSdk() throws Exception;
}