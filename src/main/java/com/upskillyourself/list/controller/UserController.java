/*
 * *
 *  * *******************************************************************************
 *  * Copyright ©2022.
 *   Upskillyourself - All rights reserved.
 *  *
 *  * All information contained herein is, and remains the property of Upskillyourself.
 *  * Upskillyourself including, without limitation, all software and other elements thereof,
 *  * are owned or controlled exclusively by Upskillyourself and protected by copyright, patent
 *  * and other laws. Use without permission is prohibited.
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  *
 *  * For further information contact Upskillyourself at info@Upskillyourself.com.
 *  * *******************************************************************************
 *
 */

package com.upskillyourself.list.controller;

import com.upskillyourself.list.constants.LogConstants;
import com.upskillyourself.list.exchange.request.UserRequest;
import com.upskillyourself.list.exchange.response.UserResponse;
import com.upskillyourself.list.service.CreateUserService;
import com.upskillyourself.list.service.DeleteUserService;
import com.upskillyourself.list.service.FindUserService;
import com.upskillyourself.list.service.UpdateUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
public class UserController {

    private final CreateUserService createUserService;

    private final FindUserService findUserService;

    private final DeleteUserService deleteUserService;

    private final UpdateUserService updateUserService;

    public UserController(CreateUserService createUserService,
                          FindUserService findUserService,
                          DeleteUserService deleteUserService,
                          UpdateUserService updateUserService) {
        this.createUserService = createUserService;
        this.findUserService = findUserService;
        this.deleteUserService = deleteUserService;
        this.updateUserService = updateUserService;
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
            @PathVariable(required = true) String emailId) {
        String methodName = "FindUserByEmailId";
        log.trace(LogConstants.TRACE_METHOD_ENTRY, methodName);
        UserRequest request = new UserRequest();
        request.setEmailId(emailId);
        UserResponse response = this.findUserService.process(request);
        log.trace(LogConstants.TRACE_METHOD_EXIT, methodName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/user/{emailId}")
    public ResponseEntity<UserResponse> deleteUserByEmailId(
            @PathVariable(required = true) String emailId) {
        String methodName = "DeleteUserByEmailId";
        log.trace(LogConstants.TRACE_METHOD_ENTRY, methodName);
        UserRequest request = new UserRequest();
        request.setEmailId(emailId);
        UserResponse response = this.deleteUserService.process(request);
        log.trace(LogConstants.TRACE_METHOD_EXIT, methodName);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/user/{emailId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable(required = true) String emailId,
                                                   @RequestBody(required = true) UserRequest request) {
        String methodName = "UpdateUser";
        log.trace(LogConstants.TRACE_METHOD_ENTRY, methodName);
        request.setEmailId(emailId);
        UserResponse response = this.updateUserService.process(request);
        log.trace(LogConstants.TRACE_METHOD_EXIT, methodName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
