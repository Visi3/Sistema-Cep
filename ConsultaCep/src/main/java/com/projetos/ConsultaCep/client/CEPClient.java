package com.projetos.ConsultaCep.client;

import org.springframework.web.client.RestTemplate;

import com.projetos.ConsultaCep.dto.CEPResponse;

public class CEPClient {
    private final String CEP_URL = "https://viacep.com.br/ws/";

    public CEPResponse consultarCEP(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = CEP_URL + cep + "/json";
        return restTemplate.getForObject(url, CEPResponse.class);
    }
}