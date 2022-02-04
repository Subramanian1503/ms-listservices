package com.upskillyourself.list.constants;

public final class ListConstants {

    //REGEX
    public static final String REGEX_USERNAME = "[a-zA-Z]";
    public static final String REGEX_PROFILE_PICTURE_IMAGE = "([^\\s]+(\\.(?i)(jpe?g|png|gif|bmp))$)";
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";
    public static final String REGEX_PHONE_NUMBER = "^\\d{10}$";

}
