package com.example.demo.infra.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ms-clientes", path ="/clientes")
public interface ClienteResourceClient {
	
	 @GetMapping
	 public String status();
	 
	 @GetMapping(params = "cpf")
	 public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf);
	
}
