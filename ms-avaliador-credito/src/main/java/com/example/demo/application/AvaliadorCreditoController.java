package com.example.demo.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.exception.DadosClienteNotFoundException;
import com.example.demo.application.exception.ErroComunicacaoMicroservicesException;
import com.example.demo.domain.model.DadosAvaliacao;
import com.example.demo.domain.model.RetornoAvaliacaoCliente;
import com.example.demo.domain.model.SituacaoCliente;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("avaliacoes-credito")
@RequiredArgsConstructor
public class AvaliadorCreditoController {
	
	private final AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity consultarSituacaoCliente(@RequestParam("cpf") String cpf){
        try {
            SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
            return ResponseEntity.ok(situacaoCliente);
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity realizarAvaliacao( @RequestBody DadosAvaliacao dados ){
        try {
            RetornoAvaliacaoCliente retornoAvaliacaoCliente = avaliadorCreditoService
                    .realizarAvaliacao(dados.getCpf(), dados.getRenda());
            return ResponseEntity.ok(retornoAvaliacaoCliente);
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }
}
