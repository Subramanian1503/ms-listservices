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

package com.upskillyourself.list.service.impl;

import com.upskillyourself.list.constants.LogConstants;
import com.upskillyourself.list.core.validation.ValidatorComponent;
import com.upskillyourself.list.entity.User;
import com.upskillyourself.list.exchange.request.UserRequest;
import com.upskillyourself.list.exchange.response.UserResponse;
import com.upskillyourself.list.repository.UserRepository;
import com.upskillyourself.list.service.CreateUserService;
import com.upskillyourself.list.validator.CreateUserValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class CreateUserServiceImpl implements CreateUserService {

    private final UserRepository userRepository;

    private final CreateUserValidator createUserValidator;

    public CreateUserServiceImpl(UserRepository userRepository, CreateUserValidator createUserValidator) {
        this.userRepository = userRepository;
        this.createUserValidator = createUserValidator;
    }

    @Override
    public List<ValidatorComponent> getValidator() {
        List<ValidatorComponent> userValidatorComponentList = new ArrayList<>();
        userValidatorComponentList.add(this.createUserValidator);
        return userValidatorComponentList;
    }

    @Override
    public UserResponse process(UserRequest input) {
        User userEntity = input.convertRequestToEntity();
        log.info(LogConstants.INFO_USER_REQUEST_CONVERT_TO_ENTITY, userEntity.toString());
        userEntity = this.userRepository.save(userEntity);
        log.info(LogConstants.INFO_CREATE_USER_SUCCESS);
        return userEntity.convertEntityToResponse();
    }

}
