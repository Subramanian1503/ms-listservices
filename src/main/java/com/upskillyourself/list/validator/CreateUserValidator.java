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

package com.upskillyourself.list.validator;

import com.upskillyourself.list.constants.ErrorCode;
import com.upskillyourself.list.constants.ListConstants;
import com.upskillyourself.list.constants.LogConstants;
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
public class CreateUserValidator implements ValidatorComponent {

    private final ListHelper listHelper;

    public CreateUserValidator(ListHelper listHelper) {
        this.listHelper = listHelper;
    }

    @Override
    public void preProcess(InputModel inputModel) {
        UserRequest request = (UserRequest) inputModel;
        // check the userName
        ListUtil.validate(request.getName(),
                ErrorCode.ERROR_CODE_INVALID_USER_NAME,
                "Invalid User Name",
                LogConstants.ERROR_VALIDATION_CREATE_USER);
        // check the profile picture link
        ListUtil.validateWithRegex(request.getProfilePicture(),
                ErrorCode.ERROR_CODE_INVALID_PROFILE_PICTURE,
                "Invalid Profile Picture", ListConstants.REGEX_PROFILE_PICTURE_IMAGE);
        // check the emailId
        ListUtil.validateWithRegex(request.getEmailId(),
                ErrorCode.ERROR_CODE_INVALID_EMAIL_ID,
                "Invalid EmailId", ListConstants.REGEX_EMAIL);
        // check the phoneNumber
        ListUtil.validateWithRegex(request.getPhoneNumber(),
                ErrorCode.ERROR_CODE_INVALID_PHONE_NUMBER,
                "Invalid PhoneNumber", ListConstants.REGEX_PHONE_NUMBER);
        // check whether already user registered with the mailId
        if (this.listHelper.checkWhetherEmailIdExists(request))
            throw new ValidationException(ErrorCode.ERROR_CODE_TODO_USER + ErrorCode.ERROR_CODE_USER_ALREADY_EXISTS,
                    "User Already Exists");
    }

}
