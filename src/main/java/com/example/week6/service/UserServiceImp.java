package com.example.week6.service;

import com.example.week6.dao.UserRepository;
import com.example.week6.entity.Users;
import com.example.week6.rabbit.producer.UserProducer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService{

    @Autowired
    private UserProducer userProducer;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean createUser() {
        try {
            Users users = new Users();
            for(int i = 0; i < 50; i++){
                userProducer.sendToQueue(users);
            }
            return true;
        } catch (Exception exception){
            return false;
        }
    }

    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }
}
