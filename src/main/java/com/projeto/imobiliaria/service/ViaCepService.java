package com.projeto.imobiliaria.service;

import com.projeto.imobiliaria.domain.model.Endereco;
import org.springframework.web.bind.annotation.PathVariable;

public interface ViaCepService {
    Endereco consultaEndereco (@PathVariable("cep") String cep);
}
