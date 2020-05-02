package com.amazonconnect.api.service;


import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.connect.AmazonConnect;
import com.amazonaws.services.connect.AmazonConnectClient;
import com.amazonaws.services.connect.model.ListUsersRequest;
import com.amazonaws.services.connect.model.ListUsersResult;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class AmazonConnectServiceImpl implements AmazonConnectService {

    @Autowired
    public RestTemplate restTemplate;

//    @Autowired
//    public AmazonConnect amazonConnect;

    @Override
    public String listUser() {
//        String serviceUrl = "https://connect.us-east-1.amazonaws.com/users-summary/1dde138d-0d27-4ac2-b726-8409d003c411";
//        HttpMethod method = GET;
//        HttpHeaders headers = getHttpHeaders();
//        HttpEntity<Object> requestEntity = new HttpEntity<>(String, headers);
//        try {
//            restTemplate.exchange(serviceUrl, method, requestEntity, String.class);
//        } catch (HttpClientErrorException ex) {
//            logger.exception(txnCorrelationId, ex);
//            logger.warning(txnCorrelationId, GOT_THE_RESPONSE + ex.getResponseBodyAsString());
//            ErrorData errorData = new ErrorData(ex.getRawStatusCode(), CMP_API_ERR_004, ":" + CMP_API_NOT_FOUND_ERR_MSG + ":" + ex.getStatusText());
//            throw new GenericClientException(errorData);
//        }
        return null;
    }

    public String listUserUsingSdk() throws Exception {

        /*
         * The ProfileCredentialsProvider will return your [default]
         * credential profile by reading from the credentials file located at
         * (~/.aws/credentials).
         */
        AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider().getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                            "Please make sure that your credentials file is at the correct " +
                            "location (~/.aws/credentials), and is in valid format.",
                    e);
        }

        //Endpoint = https://connect.us-east-1.amazonaws.com
        AmazonConnect amazonConnect = AmazonConnectClient.builder()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("connect.us-east-1.amazonaws.com", "us-east-1"))
                .build();
        String arn = "arn:aws:connect:us-east-1:831568316818:instance/1dde138d-0d27-4ac2-b726-8409d003c411";
        ListUsersResult listUsersResult = amazonConnect.listUsers(new ListUsersRequest().withInstanceId(arn));

        String str = new ObjectMapper().writeValueAsString(listUsersResult.getUserSummaryList());
        return str;

    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(APPLICATION_JSON));
        return requestHeaders;
    }
}
