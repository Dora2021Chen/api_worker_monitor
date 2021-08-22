package com.workerMonitor.api.common.response;

import java.util.HashMap;

public interface Const {
    Integer maxLen = 50;
    String RESPONSE_FORMAT = "application/json";

    int STATUS_CODE_SUCCEED = 0;
    int STATUS_CODE_FAIL = 1000;
    int STATUS_CODE_FAIL_PARAM_NULL = 1001;
    int STATUS_CODE_FAIL_PARAM_INVALID = 1002;
    int STATUS_CODE_FAIL_PARAM_EMPTY = 1003;
    int STATUS_CODE_FAIL_PARAM_TOO_LONG = 1004;
    int STATUS_CODE_FAIL_USER_NAME_EXISTS = 1100;
    int STATUS_CODE_FAIL_USER_PHONE_EXISTS = 1101;
    int STATUS_CODE_FAIL_USER_EMAIL_EXISTS = 1102;
    int STATUS_CODE_FAIL_USER_ID_NOT_EXISTS = 1103;
    int STATUS_CODE_FAIL_USER_NAME_NOT_EXISTS = 1104;
    int STATUS_CODE_FAIL_PASSWORD_WRONG = 1105;

    HashMap<Integer, String> STATUS_MAP = new HashMap<Integer, String>() {{
        put(STATUS_CODE_SUCCEED, "succeed");
        put(STATUS_CODE_FAIL, "internal error");
        put(STATUS_CODE_FAIL_PARAM_NULL, "parameter is null");
        put(STATUS_CODE_FAIL_PARAM_INVALID, "parameter is invalid");
        put(STATUS_CODE_FAIL_PARAM_EMPTY, "parameter is empty");
        put(STATUS_CODE_FAIL_PARAM_TOO_LONG, "parameter is too long");
        put(STATUS_CODE_FAIL_USER_NAME_EXISTS, "user name exists");
        put(STATUS_CODE_FAIL_USER_PHONE_EXISTS, "phone exists");
        put(STATUS_CODE_FAIL_USER_EMAIL_EXISTS, "email exists");
        put(STATUS_CODE_FAIL_USER_ID_NOT_EXISTS, "user id not exits");
        put(STATUS_CODE_FAIL_USER_NAME_NOT_EXISTS, "user name not exits");
        put(STATUS_CODE_FAIL_PASSWORD_WRONG, "password wrong");
    }};
}
