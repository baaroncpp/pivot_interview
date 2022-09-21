package com.interview.client.network;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author bkaaron
 * @created 21/09/2022
 * @project pivot_int
 */
@Service
public class ClientC {

    private RestTemplate restTemplate = new RestTemplate();

    public void makeRequest(){
        String url = "http://localhost:8081/api/v1/test";
        ResponseEntity<String> response = restTemplate.getForEntity(url , String.class);
        System.out.println(response.getBody());
    }



}
