package com.example.demo.infra.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.model.Cartao;
import com.example.demo.domain.model.CartaoClienteDTO;

@FeignClient(value = "ms-cartoes", path ="/cartoes")
public interface CartoesResourceClient {
	
	 @GetMapping(params = "cpf")
	 public ResponseEntity<List<CartaoClienteDTO>> getCartoesByCliente(String cpf);
	 
	 @GetMapping(params = "renda")
	 ResponseEntity<List<Cartao>> getCartoesRendaAteh(@RequestParam("renda") Long renda);

}
