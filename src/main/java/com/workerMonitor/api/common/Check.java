package com.workerMonitor.api.common;

import com.workerMonitor.api.common.response.Const;
import com.workerMonitor.api.common.response.ResponseRow;

import java.lang.reflect.Field;
import java.util.List;

public class Check {

    public static <T> ResponseRow<T> CheckStringNotNullable(T object, int maxLen, List<String> fieldNameList) {
        ResponseRow<T> responseRow;
        String fieldName;
        for (int i = 0; i < fieldNameList.size(); i++) {
            fieldName = fieldNameList.get(i);
            responseRow = CheckStringNotNullable(object, maxLen, fieldName);
            if (responseRow.statusCode != Const.STATUS_CODE_SUCCEED) {
                return responseRow;
            }
        }

        return new ResponseRow();
    }

    public static <T> ResponseRow<T> CheckStringNotNullable(T object, int maxLen, String fieldName) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(object);
            if (value == null) {
                return new ResponseRow(Const.STATUS_CODE_FAIL_PARAM_NULL);
            }

            String str = (String) value;

            String strTrim = str.trim();
            if (strTrim.length() == 0) {
                return new ResponseRow(Const.STATUS_CODE_FAIL_PARAM_EMPTY);
            }

            if (strTrim.length() > maxLen) {
                return new ResponseRow(Const.STATUS_CODE_FAIL_PARAM_TOO_LONG);
            }

            field.set(object, strTrim);
        } catch (Exception ex) {
            return new ResponseRow(Const.STATUS_CODE_FAIL);
        }

        return new ResponseRow();
    }
}
