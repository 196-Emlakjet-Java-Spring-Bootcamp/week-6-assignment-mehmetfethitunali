package com.example.week6.controller;

import com.example.week6.entity.Advertisement;
import com.example.week6.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/advertisements")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    public ResponseEntity<List<Advertisement>> getAll(){
        return new ResponseEntity<>(advertisementService.getAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Advertisement> createAdvertisement(){
        if (advertisementService.createAdvertisement()){
            return new ResponseEntity("Advertisement Created", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Not Created", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/searchbydate")
    public ResponseEntity<List<Advertisement>> findByCreatedAt(@RequestParam Date date){
        return new ResponseEntity(advertisementService.findByCreatedAt(date), HttpStatus.OK);
    }

    @GetMapping("/searchbyprice")
    public ResponseEntity<List<Advertisement>> findByPrice(@RequestParam Long min, @RequestParam Long max){
        return new ResponseEntity(advertisementService.findByPrice(min,max),HttpStatus.OK);
    }

    @GetMapping("/searchbytext")
    public ResponseEntity<List<Advertisement>> findByTitleOrDetailedMessage (@RequestParam String text){
        return new ResponseEntity(advertisementService.findByTitleOrDetailedMessage(text), HttpStatus.OK);
    }

}
