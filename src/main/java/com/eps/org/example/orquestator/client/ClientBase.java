package com.eps.org.example.orquestator.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eps.org.example.orquestator.controller.OrqEpsController;
import com.eps.org.example.orquestator.models.EpsValidate;

@Service
public class ClientBase {

    Logger logger = LoggerFactory.getLogger(OrqEpsController.class);

    @Value("${apiOnepremise.url}")
    private String url;

    private RestTemplate restTemplate = new RestTemplate();

    public EpsValidate callApiOP(EpsValidate epsDetail) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<EpsValidate> request = new HttpEntity<>(epsDetail, headers);
        EpsValidate eps = restTemplate.postForObject(url, request, EpsValidate.class);
        logger.info(url);
        return eps;
    }
}
