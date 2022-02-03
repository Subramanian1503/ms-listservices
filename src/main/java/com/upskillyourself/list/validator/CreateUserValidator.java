package com.upskillyourself.list.validator;

import com.upskillyourself.list.constants.ErrorCode;
import com.upskillyourself.list.constants.LogConstants;
import com.upskillyourself.list.controller.UserController;
import com.upskillyourself.list.core.exception.ValidationException;
import com.upskillyourself.list.core.model.InputModel;
import com.upskillyourself.list.core.validation.ValidatorComponent;
import com.upskillyourself.list.exchange.request.UserRequest;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@NoArgsConstructor
@Component
public class CreateUserValidator implements ValidatorComponent {

    @Override
    public void preProcess(InputModel inputModel) {
        UserRequest request = (UserRequest) inputModel;
        // check the userName
        validate(request.getName(), ErrorCode.INVALID_USER_NAME, "Invalid User Name");
        // check the profile picture link
        validate(request.getProfilePicture(), ErrorCode.INVALID_PROFILE_PICTURE, "Invalid Profile Picture");
    }

    private void validate(String requestToValidate, String errorValue, String errorMessage) {
        if (requestToValidate != null && requestToValidate.isEmpty()) {
            log.error(LogConstants.ERROR_VALIDATION_CREATE_USER,errorMessage);
            throw new ValidationException(ErrorCode.ERROR_CODE_TODO_USER + errorValue, errorMessage);
        }
    }

}
