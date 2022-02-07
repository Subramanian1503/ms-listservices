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
import com.upskillyourself.list.service.UpdateUserService;
import com.upskillyourself.list.utility.ListUtil;
import com.upskillyourself.list.validator.UpdateUserValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Log4j2
@Service
public class UpdateUserServiceImpl implements UpdateUserService {

    private final UserRepository userRepository;

    private final UpdateUserValidator updateUserValidator;

    public UpdateUserServiceImpl(UserRepository userRepository, UpdateUserValidator updateUserValidator) {
        this.userRepository = userRepository;
        this.updateUserValidator = updateUserValidator;
    }

    @Override
    public List<ValidatorComponent> getValidator() {
        List<ValidatorComponent> userValidatorComponentList = new ArrayList<>();
        userValidatorComponentList.add(this.updateUserValidator);
        return userValidatorComponentList;
    }

    @Override
    public UserResponse process(UserRequest input) {
        User userEntity = getUserFromDB(input);
        log.info(LogConstants.INFO_USER_REQUEST_CONVERT_TO_ENTITY, Objects.requireNonNull(userEntity).toString());
        userEntity = updateUserFromDB(input, userEntity);
        userEntity = this.userRepository.save(userEntity);
        log.info(LogConstants.INFO_CREATE_USER_SUCCESS);
        return userEntity.convertEntityToResponse();
    }

    private User getUserFromDB(UserRequest input) {
        Optional<User> userFromDB = this.userRepository.findUserByEmailId(input.getEmailId());
        return userFromDB.orElse(null);
    }

    private User updateUserFromDB(UserRequest input, User userEntity) {
        if (!ListUtil.isNotValidString(input.getName()))
            userEntity.setName(input.getName());
        if (!ListUtil.isNotValidString(input.getPhoneNumber()))
            userEntity.setPhoneNumber(input.getPhoneNumber());
        if (!ListUtil.isNotValidString(input.getProfilePicture()))
            userEntity.setProfilePicture(input.getProfilePicture());
        return userEntity;
    }
}
