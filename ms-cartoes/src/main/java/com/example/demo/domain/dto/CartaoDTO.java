package com.example.demo.domain.dto;

import java.math.BigDecimal;

import com.example.demo.domain.BandeiraCartao;
import com.example.demo.domain.Cartao;

import lombok.Data;

@Data
public class CartaoDTO {
	private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limite );
    }

}
