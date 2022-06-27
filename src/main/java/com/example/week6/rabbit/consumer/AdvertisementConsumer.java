package com.example.week6.rabbit.consumer;
import com.example.week6.dao.AdvertisementRepository;
import com.example.week6.dao.UserRepository;
import com.example.week6.entity.Advertisement;
import com.example.week6.entity.Users;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdvertisementConsumer {

    String [] title1 = {"satilik","kiralik","temiz","doktordan","ihtiyacdan"};
    String [] title2 = {"ev","araba","villa","arsa","motor","yat","daire"};
    String [] description = {"ihtiyactan satilik","asansorlu","kombili","fiber altyapisi","guven emlak","aktas emlak","kalite bizim isimiz","guven bizim isimiz"};
    @Autowired
    UserRepository userRepository;
    @Autowired
    AdvertisementRepository advertisementRepository;

    @RabbitListener(queues = "queue2-queue")
    public void handleOperation (Advertisement advertisement) throws InterruptedException {

        Thread.sleep(1000);
        System.out.println("(Advertisement) Message recieved...");

        Users user1 = userRepository.getRandomUser();
        advertisement.setUsers(user1);
        advertisement.setTitle(title1[(int)(Math.random()*title1.length)] + ", " + title2[(int)(Math.random()*title2.length)]);
        advertisement.setDetailedMessage(description[(int)(Math.random()*description.length)] + ", "+description[(int)(Math.random()* description.length)]);
        advertisement.setPrice((long)(Math.random()*3000000));
        advertisement.setCreatedAt(new Date());

        advertisementRepository.save(advertisement);

    }
}
