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
import com.upskillyourself.list.core.model.InputModel;
import com.upskillyourself.list.core.validation.ValidatorComponent;
import com.upskillyourself.list.exchange.request.UserRequest;
import com.upskillyourself.list.utility.ListUtil;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@NoArgsConstructor
@Component
public class FindUserValidator implements ValidatorComponent {

    @Override
    public void preProcess(InputModel inputModel) {
        UserRequest request = (UserRequest) inputModel;
        // check the emailId
        ListUtil.validateWithRegex(request.getEmailId(), ErrorCode.ERROR_CODE_INVALID_EMAIL_ID, "Invalid EmailId", ListConstants.REGEX_EMAIL);
    }
}
