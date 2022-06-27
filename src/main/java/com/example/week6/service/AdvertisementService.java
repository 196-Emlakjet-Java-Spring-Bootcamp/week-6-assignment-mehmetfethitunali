package com.example.week6.service;

import com.example.week6.entity.Advertisement;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface AdvertisementService {

    boolean createAdvertisement();

    List<Advertisement> getAll();

    List<Advertisement> findByCreatedAt(Date date);

    List<Advertisement> findByPrice(Long min, Long max);

    List<Advertisement> findByTitleOrDetailedMessage(String text);


}
