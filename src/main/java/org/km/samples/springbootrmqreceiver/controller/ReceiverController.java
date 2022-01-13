package org.km.samples.springbootrmqreceiver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.km.samples.springbootrmqreceiver.domain.Message;
import org.km.samples.springbootrmqreceiver.repository.MessageRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RestController
@RequestMapping("/receiver")

public class ReceiverController {

    public static final String KEDAQ = "kedaQ";

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
	public MessageRepository msgRepo;


   
    @GetMapping("/receiveMessage")
    public Iterable<Message> receive(){

        Iterable<Message> all = msgRepo.findAll();
		msgRepo.deleteAll();
		return all;

        
    }

    
}
