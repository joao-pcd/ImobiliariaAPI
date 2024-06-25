package com.projeto.imobiliaria.service.impl;

import com.projeto.imobiliaria.domain.model.Endereco;
import com.projeto.imobiliaria.service.ViaCepService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepServiceImpl implements ViaCepService {
    @Override
    public Endereco consultaEndereco(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Endereco> resp = restTemplate.getForEntity(
                String.format("https://viacep.com.br/ws/%s/json/", cep), Endereco.class
        );
        return resp.getBody();
    }
}
