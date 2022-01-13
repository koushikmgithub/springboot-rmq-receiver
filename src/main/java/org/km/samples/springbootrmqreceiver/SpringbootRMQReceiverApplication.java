
package org.km.samples.springbootrmqreceiver;

import org.km.samples.springbootrmqreceiver.domain.Message;
import org.km.samples.springbootrmqreceiver.repository.MessageRepository;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@Slf4j
public class SpringbootRMQReceiverApplication {

    public static final String KEDAQ = "kedaQ";

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRMQReceiverApplication.class, args);
    }

    @Autowired
	public MessageRepository msgRepo;

  
    @Bean
    public Queue kedaQueue() {
        return new Queue(KEDAQ, false);
    }

    @RabbitListener(queues = KEDAQ)
	public void listen(String message) {
	    log.info("Message received from kedaQ : " + message);
		msgRepo.save(new Message(message));
	}


    

}
