package com.events.userevents.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class UserEventsController {

    public UserEventsController() {}

    @GetMapping
    public ResponseEntity<String> testEventsEndpoint() {
        return new ResponseEntity<>("Test events endpoint", HttpStatus.OK);
    }
}
