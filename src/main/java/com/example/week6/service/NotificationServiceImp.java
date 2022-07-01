package com.example.week6.service;

import com.example.week6.dao.NotificationRepository;
import com.example.week6.entity.Advertisement;
import com.example.week6.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class NotificationServiceImp implements NotificationService{

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public boolean createNotification(Advertisement advertisement) {

        try {
            Notification notification = new Notification();

            notification.setUsers(advertisement.getUsers());
            notification.setAdvertisement(advertisement);
            notification.setDate(new Date());
            notification.setMessage("Advertisement created.\t\tadvertisemen_id : "+advertisement.getId());
            notification.setState("SENT");

            notificationRepository.save(notification);

            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
