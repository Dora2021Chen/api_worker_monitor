package com.workerMonitor.api.service;

import com.workerMonitor.api.common.response.Const;
import com.workerMonitor.api.common.response.ResponseRow;
import com.workerMonitor.api.model.SystemLogModel;
import com.workerMonitor.api.repository.SystemLogRepository;
import org.springframework.stereotype.Service;

@Service
public class SystemLogService {
    private final SystemLogRepository systemLogRepository;

    public SystemLogService(SystemLogRepository systemLogRepository) {
        this.systemLogRepository = systemLogRepository;
    }

    public ResponseRow<SystemLogModel> save(SystemLogModel systemLogModel) {
        ResponseRow<SystemLogModel> responseRow;
        try {
            responseRow = new ResponseRow<>(systemLogRepository.save(systemLogModel));
        } catch (Exception ex) {
            responseRow = new ResponseRow<>(Const.STATUS_CODE_FAIL, ex.getMessage());
        }

        return responseRow;
    }

}
