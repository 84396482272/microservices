package com.example.demo.infra.mqueue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class SolicitacaoEmissaoCartaoPublisher {
	
	private final RabbitTemplate rabbitTemplate;
	

}
