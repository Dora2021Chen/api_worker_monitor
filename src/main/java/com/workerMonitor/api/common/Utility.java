package com.workerMonitor.api.common;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    private static final Lock lock = new ReentrantLock();
    private static Integer accessCode = 0;
    private static final Pattern validUsernamePattern = Pattern.compile("admin_[\\d]+");

    public static String getGsonStr(Object object) {
        if (object == null) {
            return "";
        }
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static void printGsonStr(Object object) {
        Gson gson = new Gson();
        if (object != null) {
            printStr(gson.toJson(object));
        } else {
            printStr("object is null");
        }
    }

    public static void printStr(String str) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dt.format(new Date())).append(": ");
        if (str != null) {
            stringBuilder.append(str);
        } else {
            stringBuilder.append("str is null");
        }

        System.out.println(stringBuilder);
    }

    public static Integer getAccessCode() {
        lock.lock();
        if (accessCode < 100000) {
            accessCode++;
        } else {
            accessCode = 0;
        }
        lock.unlock();
        return accessCode;
    }

    public static Boolean isValidUserName(String username) {
        Matcher matcher = validUsernamePattern.matcher(username);
        boolean isMatched = matcher.matches();
        return isMatched;
    }
}
