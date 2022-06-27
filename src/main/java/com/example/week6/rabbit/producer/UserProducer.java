package com.example.week6.rabbit.producer;
import com.example.week6.entity.Users;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {

    @Value("${spring.rabbit.queue1.name}")
    private String queueName;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue queue;
    public void sendToQueue (Users users) {

        System.out.println("User Creation sent to queue...");
        rabbitTemplate.convertAndSend(queueName,users);

    }



}
