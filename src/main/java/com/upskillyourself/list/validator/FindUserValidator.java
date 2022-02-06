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
