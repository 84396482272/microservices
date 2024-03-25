package com.example.demo.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.ClienteCartao;
import com.example.demo.repository.ClienteCartaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
