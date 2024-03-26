package com.example.demo.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartaoClienteDTO {
	private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;
}
