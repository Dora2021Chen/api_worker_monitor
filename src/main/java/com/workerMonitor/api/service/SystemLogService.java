package com.workerMonitor.api.service;

import com.workerMonitor.api.common.response.ResponseRow;
import com.workerMonitor.api.model.SystemLogModel;
import com.workerMonitor.api.repository.SystemLogRepository;

import java.util.Optional;

public class SystemLogService {
    private final SystemLogRepository systemLogRepository;

    public SystemLogService(SystemLogRepository systemLogRepository) {
        this.systemLogRepository = systemLogRepository;
    }

    public ResponseRow<SystemLogModel> save(SystemLogModel systemLogModel) {
        ResponseRow<SystemLogModel> responseRow = new ResponseRow<>();
        responseRow.entity = Optional.of(systemLogRepository.save(systemLogModel));

        return responseRow;
    }

}
