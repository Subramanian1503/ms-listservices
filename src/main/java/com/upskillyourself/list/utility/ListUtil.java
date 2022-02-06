package com.upskillyourself.list.utility;

import com.upskillyourself.list.constants.ErrorCode;
import com.upskillyourself.list.constants.LogConstants;
import com.upskillyourself.list.core.exception.ValidationException;
import com.upskillyourself.list.entity.User;
import com.upskillyourself.list.exception.UserNotExistsException;
import lombok.extern.log4j.Log4j2;

import java.util.Optional;
import java.util.regex.Pattern;

@Log4j2
public final class ListUtil {

    public static void validateWithRegex(String requestToValidate, String errorValue, String errorMessage, String regex) {
        if (isNotValidString(requestToValidate) || isRegexMatches(requestToValidate, regex)) {
            log.error(LogConstants.ERROR_VALIDATION_CREATE_USER, errorMessage);
            throw new ValidationException(ErrorCode.ERROR_CODE_TODO_USER + errorValue, errorMessage);
        }
    }

    public static void validateRequest(String requestToValidate,
                                       String regexToValidate,
                                       String errorMessage,
                                       String errorValue) {
        boolean isValidString = !ListUtil.isNotValidString(requestToValidate);
        if (isValidString && ListUtil.isRegexMatches(requestToValidate, regexToValidate)) {
            log.error(LogConstants.ERROR_VALIDATION_UPDATE_USER, errorMessage);
            throw new ValidationException(ErrorCode.ERROR_CODE_TODO_USER + errorValue, errorMessage);
        }
    }

    public static void checkIfUserExists(Optional<User> userEntity, String emailId) {
        if (userEntity.isEmpty()) {
            log.error(LogConstants.ERROR_FIND_USER_FAILED, emailId);
            throw new UserNotExistsException(ErrorCode.ERROR_CODE_TODO_USER + ErrorCode.ERROR_CODE_USER_NOT_EXISTS
                    , LogConstants.ERROR_FIND_USER_FAILED);
        }
    }

    public static boolean isRegexMatches(String requestToValidate, String regex) {
        return Pattern.compile(regex).matcher(requestToValidate).matches();
    }

    public static void validate(String requestToValidate, String errorValue, String errorMessage, String logMessage) {
        if (isNotValidString(requestToValidate)) {
            log.error(logMessage, errorMessage);
            throw new ValidationException(ErrorCode.ERROR_CODE_TODO_USER + errorValue, errorMessage);
        }
    }

    public static boolean isNotValidString(String requestToValidate) {
        return requestToValidate == null || requestToValidate.isEmpty();
    }
}
