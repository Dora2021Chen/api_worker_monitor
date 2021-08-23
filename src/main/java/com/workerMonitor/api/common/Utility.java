package com.workerMonitor.api.common;

import com.google.gson.Gson;
import com.workerMonitor.api.model.WorkerModel;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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


    public static void write2CsvFile(String username, List<WorkerModel> workerModelList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("result").append(System.currentTimeMillis()).append(".csv");
        String fileName = stringBuilder.toString();
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("username").append(",");
            writer.append("workerId").append(",");
            writer.append("workerName").append(",");
            writer.append("cpuUsage").append(",");
            writer.append("ramUsage").append(",");
            writer.append("vmemUsage").append(",");
            writer.append("gpuUsage");
            writer.append('\n');
            for (WorkerModel workerModel : workerModelList) {
                writer.append(username).append(",");
                writer.append(workerModel.getWorkerId().toString()).append(",");
                writer.append(workerModel.getWorkerName()).append(",");
                writer.append(workerModel.getCpuUsage()).append(",");
                writer.append(workerModel.getRamUsage()).append(",");
                writer.append(workerModel.getVmemUsage()).append(",");
                writer.append(workerModel.getGpuUsage());
                writer.append('\n');
            }

            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
