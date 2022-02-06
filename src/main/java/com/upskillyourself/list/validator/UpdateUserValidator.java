package com.upskillyourself.list.validator;

import com.upskillyourself.list.constants.ErrorCode;
import com.upskillyourself.list.constants.ListConstants;
import com.upskillyourself.list.core.exception.ValidationException;
import com.upskillyourself.list.core.model.InputModel;
import com.upskillyourself.list.core.validation.ValidatorComponent;
import com.upskillyourself.list.exchange.request.UserRequest;
import com.upskillyourself.list.helper.ListHelper;
import com.upskillyourself.list.utility.ListUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class UpdateUserValidator implements ValidatorComponent {

    private final ListHelper listHelper;

    public UpdateUserValidator(ListHelper listHelper) {
        this.listHelper = listHelper;
    }

    @Override
    public void preProcess(InputModel inputModel) {
        UserRequest request = (UserRequest) inputModel;
        // check the profile picture link
        ListUtil.validateRequest(request.getProfilePicture(),
                ListConstants.REGEX_PROFILE_PICTURE_IMAGE,
                ErrorCode.ERROR_CODE_INVALID_PROFILE_PICTURE,
                "Invalid Profile Picture");
        // check the emailId
        ListUtil.validateRequest(request.getEmailId(),
                ListConstants.REGEX_EMAIL,
                ErrorCode.ERROR_CODE_INVALID_EMAIL_ID,
                "Invalid EmailId");
        // check the phoneNumber
        ListUtil.validateRequest(request.getPhoneNumber(),
                ListConstants.REGEX_PHONE_NUMBER,
                ErrorCode.ERROR_CODE_INVALID_PHONE_NUMBER,
                "Invalid PhoneNumber");
        // check whether already user registered with the mailId
        boolean isEmailIdAlreadyExists = this.listHelper.checkWhetherEmailIdExists(request);
        if (!isEmailIdAlreadyExists)
            throw new ValidationException(ErrorCode.ERROR_CODE_TODO_USER + ErrorCode.ERROR_CODE_USER_NOT_EXISTS,
                    "User Not Exists");
    }

}
