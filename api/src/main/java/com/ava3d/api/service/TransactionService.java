package com.ava3d.api.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class TransactionService {
    private String publicKey="";

    public static void loginEpayco(){
        RestTemplate restTemplate= new RestTemplate();

        // Crea los encabezados de la solicitud (headers)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth("elian.pbh@gmail.com", "Qap110612.");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("https://apify.epayco.co/login/mail", entity, String.class);
        String responseBody = responseEntity.getBody();

        int startIndex = responseBody.indexOf(":") + 2;
        int endIndex = responseBody.indexOf("\"", startIndex);
        String token= responseBody.substring(startIndex,endIndex);
        System.out.println(token);
    }
}
