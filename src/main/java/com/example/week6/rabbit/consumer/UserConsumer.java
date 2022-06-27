package com.example.week6.rabbit.consumer;

import com.example.week6.dao.UserRepository;
import com.example.week6.entity.Users;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserConsumer {

    String [] name1 = {"Ahmet", "Mehmet", "Fethi", "Aysu", "Ekrem", "Eren", "Murat", "Efe", "Yigit", "Berkant", "Yasin", "Elif", "Merve", "Zeynep", "İlayda", "Gaye"};
    String [] name2 = {"Yilmaz","Demir","Guclu","Yorulmaz","Keten","Hizli","Kosan","Kerim","Kalay","Bayrak","Toprak","Milas","Atar","Gider","Bardak","Askar","Kumas"};

    @Autowired
    UserRepository userRepository;
    List<Users> usersList = new ArrayList<Users>();

    @RabbitListener(queues = "queue1-queue")
    public void handleOperation (Users users) throws InterruptedException {

        Thread.sleep(1000);
        System.out.println("(User) Message recieved...");

        users.setUserName(name1[(int)(Math.random()*name1.length)]);
        users.setUserSurname(name2[(int)(Math.random()*name2.length)]);
        users.setUserMail(users.getUserName().toLowerCase() + users.getUserSurname().toLowerCase() + "@gmail.com");

        usersList.add(users);
        userRepository.save(users);
    }


}
