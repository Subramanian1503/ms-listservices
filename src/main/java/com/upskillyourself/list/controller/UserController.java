package com.upskillyourself.list.controller;

import com.upskillyourself.list.constants.LogConstants;
import com.upskillyourself.list.exchange.request.UserRequest;
import com.upskillyourself.list.exchange.response.UserResponse;
import com.upskillyourself.list.service.CreateUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class UserController {

    private final CreateUserService createUserService;

    public UserController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        String methodName = "CreateUser";
        log.trace(LogConstants.TRACE_METHOD_ENTRY, methodName);
        UserResponse response = this.createUserService.process(request);
        log.trace(LogConstants.TRACE_METHOD_EXIT, methodName);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
