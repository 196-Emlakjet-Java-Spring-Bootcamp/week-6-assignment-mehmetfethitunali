package com.example.week6.rabbit.producer;
import com.example.week6.entity.Advertisement;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementProducer {

    @Value("${spring.rabbit.queue2.name}")
    private String queueName;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue queue;

    public void sendToQueue (Advertisement advertisement) {

        System.out.println("Advertisement Creation sent to queue...");
        rabbitTemplate.convertAndSend(queueName, advertisement);

    }
}
