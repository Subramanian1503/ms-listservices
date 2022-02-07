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

package com.upskillyourself.list.core.exception;

import lombok.Getter;

public class TodoServiceException extends RuntimeException {

    private static final long serialVersionUID = -3736284633578999598L;

    /**
     * Constant <code>ERR_NONE=0</code>
     */
    public static final String ERR_NONE = "CORE_0";

    /** Constant <code>ERR_UNKNOWN=1</code> */
    public static final String ERR_UNKNOWN = "CORE_1";

    /** Constant <code>ERR_INVALID_PARAMETERS=2</code> */
    public static final String ERR_INVALID_PARAMETERS = "CORE_2";

    @Getter
    private final String errorCode;

    @Getter
    private final String errorMessage;

    @Getter
    private final int httpStatusCode;

    @Getter
    private final transient Object[] parameters;

    public TodoServiceException(String errorCode) {
        this(errorCode, null, null);
    }

    public TodoServiceException(String errorCode, String errorMessage) {
        this(errorCode, errorMessage, null);
    }

    public TodoServiceException(String errorCode, String errorMessage, Throwable throwable) {
        this(errorCode, errorMessage, throwable, -1);
    }

    public TodoServiceException(String errorCode, String errorMessage, Throwable throwable, int httpStatusCode,
                                Object... parameters) {
        super(errorMessage, throwable);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.httpStatusCode = httpStatusCode;
        this.parameters = parameters.clone();
    }
}
