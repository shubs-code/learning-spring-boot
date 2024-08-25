package com.shubham.subscription.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    ResponseEntity<?> getRoot(){
        return new ResponseEntity<>("Hey mate",HttpStatus.OK);
    }
}
