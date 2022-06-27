package com.example.week6.service;
import com.example.week6.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    boolean createUser ();

    List<Users> getAll();

}
