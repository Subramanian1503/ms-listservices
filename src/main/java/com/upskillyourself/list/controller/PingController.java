package com.upskillyourself.list.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PingController {

    /**
     * This method is used to check whether the application is active or not
     * @return LocalDateTime - return the current time when ping
     */
    @GetMapping("/ping")
    public ResponseEntity<LocalDateTime> ping(){
        return new ResponseEntity<>(LocalDateTime.now(), HttpStatus.OK);
    }
}
