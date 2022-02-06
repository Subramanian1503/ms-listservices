package com.upskillyourself.list.constants;

public final class LogConstants {

    // TRACE
    public static final String TRACE_METHOD_ENTRY = "ENTERED_INTO_METHOD_{}";
    public static final String TRACE_METHOD_EXIT = "EXITED_FROM_METHOD_{}";

    // ERROR
    public static final String ERROR_VALIDATION_CREATE_USER = "Error occurred during validation of create user request due to {}";
    public static final String ERROR_VALIDATION_CREATE_USER_MAIL_ALREADY_EXISTS = "Error occurred as email Id {} already exists";
    public static final String ERROR_FIND_USER_FAILED = "Error occurred as provided emailId {} not exists";


    // INFO
    public static final String INFO_CREATE_USER_SUCCESS = "User Created";
    public static final String INFO_FIND_USER_SUCCESS = "Find User Success";
    public static final String INFO_DELETE_USER_SUCCESS = "Delete User Success";
    public static final String INFO_CREATE_USER_REQUEST_CONVERT_TO_ENTITY = "Converted Entity value from request will be {}";
}
