package com.upskillyourself.list.service.impl;

import com.upskillyourself.list.constants.LogConstants;
import com.upskillyourself.list.core.validation.ValidatorComponent;
import com.upskillyourself.list.entity.User;
import com.upskillyourself.list.exchange.request.UserRequest;
import com.upskillyourself.list.exchange.response.UserResponse;
import com.upskillyourself.list.repository.UserRepository;
import com.upskillyourself.list.service.DeleteUserService;
import com.upskillyourself.list.validator.DeleteUserValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class DeleteUserServiceImpl implements DeleteUserService {

    private final UserRepository userRepository;

    private final DeleteUserValidator deleteUserValidator;

    public DeleteUserServiceImpl(UserRepository userRepository, DeleteUserValidator deleteUserValidator) {
        this.userRepository = userRepository;
        this.deleteUserValidator = deleteUserValidator;
    }

    @Override
    public List<ValidatorComponent> getValidator() {
        List<ValidatorComponent> userValidatorComponentList = new ArrayList<>();
        userValidatorComponentList.add(this.deleteUserValidator);
        return userValidatorComponentList;
    }

    @Override
    public UserResponse process(UserRequest input) {
        User userEntity = this.userRepository.deleteUserByEmailId(input.getEmailId());
        log.info(LogConstants.INFO_DELETE_USER_SUCCESS);
        return userEntity.convertEntityToResponse();
    }
}
