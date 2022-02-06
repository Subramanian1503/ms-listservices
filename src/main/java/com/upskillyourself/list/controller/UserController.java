package com.upskillyourself.list.controller;

import com.upskillyourself.list.constants.LogConstants;
import com.upskillyourself.list.exchange.request.UserRequest;
import com.upskillyourself.list.exchange.response.UserResponse;
import com.upskillyourself.list.service.CreateUserService;
import com.upskillyourself.list.service.FindUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
public class UserController {

    private final CreateUserService createUserService;

    private final FindUserService findUserService;

    public UserController(CreateUserService createUserService, FindUserService findUserService) {
        this.createUserService = createUserService;
        this.findUserService = findUserService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        String methodName = "CreateUser";
        log.trace(LogConstants.TRACE_METHOD_ENTRY, methodName);
        UserResponse response = this.createUserService.process(request);
        log.trace(LogConstants.TRACE_METHOD_EXIT, methodName);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/user/{emailId}")
    public ResponseEntity<UserResponse> findUserByEmailId(
            @PathVariable(required = true, value = "emailId") String emailId) {
        String methodName = "FindUserByEmailId";
        log.trace(LogConstants.TRACE_METHOD_ENTRY, methodName);
        UserRequest request = new UserRequest();
        request.setEmailId(emailId);
        UserResponse response = this.findUserService.process(request);
        log.trace(LogConstants.TRACE_METHOD_EXIT, methodName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
