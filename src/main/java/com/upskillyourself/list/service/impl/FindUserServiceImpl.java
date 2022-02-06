package com.upskillyourself.list.service.impl;

import com.upskillyourself.list.constants.LogConstants;
import com.upskillyourself.list.core.validation.ValidatorComponent;
import com.upskillyourself.list.entity.User;
import com.upskillyourself.list.exchange.request.UserRequest;
import com.upskillyourself.list.exchange.response.UserResponse;
import com.upskillyourself.list.repository.UserRepository;
import com.upskillyourself.list.service.FindUserService;
import com.upskillyourself.list.utility.ListUtil;
import com.upskillyourself.list.validator.FindUserValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class FindUserServiceImpl implements FindUserService {

    private final UserRepository userRepository;

    private final FindUserValidator findUserValidator;

    public FindUserServiceImpl(UserRepository userRepository, FindUserValidator findUserValidator) {
        this.userRepository = userRepository;
        this.findUserValidator = findUserValidator;
    }

    @Override
    public List<ValidatorComponent> getValidator() {
        List<ValidatorComponent> userValidatorComponentList = new ArrayList<>();
        userValidatorComponentList.add(this.findUserValidator);
        return userValidatorComponentList;
    }

    @Override
    public UserResponse process(UserRequest input) {
        Optional<User> userEntity = this.userRepository.findUserByEmailId(input.getEmailId());
        ListUtil.checkIfUserExists(userEntity, input.getEmailId());
        log.info(LogConstants.INFO_FIND_USER_SUCCESS);
        return userEntity.get().convertEntityToResponse();
    }
}
