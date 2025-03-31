package com.drools.sample.controller;

import com.drools.sample.model.Participant;
import com.drools.sample.model.Rate;
import com.drools.sample.service.DroolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rule")
public class DroolsController {
    @Autowired
    private DroolsService bankService;

    @PostMapping("/getrate")
    public ResponseEntity<Rate> getRate(@RequestBody Participant participant){
        Rate rate = bankService.getRate(participant);
        return  new ResponseEntity<>(rate, HttpStatus.OK);
    }
}
