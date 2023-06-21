package com.spb.rest.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;

@Service
public class RestTemplateService {
    public String getName(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8088")
                .path("crud-api")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String > responseEntity = restTemplate.getForEntity(uri, String.class);

        return responseEntity.getBody();

    }

    public String getNameWithPathVariable(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8088")
                .path("crud-api/{name}")
                .encode()
                .build()
                .expand("srude")
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String > responseEntity = restTemplate.getForEntity(uri, String.class);

        return responseEntity.getBody();
    }

    public String getNameWithParameter(){
        URI uri = UriComponentsBuilder
               .fromUriString("http://localhost:8088")
               .path("crud-api/param")
               .queryParam("name", "srude")
               .encode()
               .build()
               .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String > responseEntity = restTemplate.getForEntity(uri, String.class);

        return responseEntity.getBody();
    }



}
