package com.workerMonitor.api.controller;

import com.workerMonitor.api.common.Utility;
import com.workerMonitor.api.common.response.Const;
import com.workerMonitor.api.common.response.ResponseRows;
import com.workerMonitor.api.model.SystemLogModel;
import com.workerMonitor.api.model.WorkerModel;
import com.workerMonitor.api.service.SystemLogService;
import com.workerMonitor.api.service.WorkerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workerMonitor/worker")
public class WorkerController {
    private final WorkerService workerService;
    private final SystemLogService systemLogService;

    public WorkerController(WorkerService workerService, SystemLogService systemLogService) {
        this.workerService = workerService;
        this.systemLogService = systemLogService;
    }

    @GetMapping(path = "getWorkerStats", produces = Const.RESPONSE_FORMAT)
    public ResponseRows<WorkerModel> getWorkerStats(@RequestParam String username) {
        Integer accessCode = Utility.getAccessCode();
        Long createAt = System.currentTimeMillis();

        ResponseRows<WorkerModel> responseRows = checkParams(username, createAt, accessCode);
        if (responseRows.statusCode != 0) {
            return responseRows;
        }

        responseRows = workerService.getWokerStatus(username, createAt, accessCode);
        return responseRows;
    }

    public ResponseRows<WorkerModel> checkParams(String username, Long createAt, Integer accessCode) {
        ResponseRows<WorkerModel> responseRows = new ResponseRows<>();
        if (username == null) {
            responseRows = new ResponseRows<>(Const.STATUS_CODE_FAIL_PARAM_NULL, "username");

            SystemLogModel systemLogModel = new SystemLogModel();
            systemLogModel.setCreateAt(createAt);
            systemLogModel.setAdminId("username is null");
            systemLogModel.setAccessCode(accessCode);
            systemLogModel.setResultCode(responseRows.statusCode);
            systemLogModel.setResultMsg(responseRows.statusMsg);
            systemLogModel.setErrorCount(1);

            systemLogModel = systemLogService.save(systemLogModel).entity.get();

            return responseRows;
        }

        if (username.trim().length() == 0) {
            responseRows = new ResponseRows<>(Const.STATUS_CODE_FAIL_PARAM_EMPTY, "username");

            SystemLogModel systemLogModel = new SystemLogModel();
            systemLogModel.setCreateAt(createAt);
            systemLogModel.setAdminId("username is empty");
            systemLogModel.setAccessCode(accessCode);
            systemLogModel.setResultCode(responseRows.statusCode);
            systemLogModel.setResultMsg(responseRows.statusMsg);
            systemLogModel.setErrorCount(1);

            systemLogModel = systemLogService.save(systemLogModel).entity.get();
            return responseRows;
        }

        if (!Utility.isValidUserName(username)) {
            responseRows = new ResponseRows<>(Const.STATUS_CODE_FAIL_INVALID_USERNAME, username);

            SystemLogModel systemLogModel = new SystemLogModel();
            systemLogModel.setCreateAt(createAt);
            systemLogModel.setAdminId(username);
            systemLogModel.setAccessCode(accessCode);
            systemLogModel.setResultCode(responseRows.statusCode);
            systemLogModel.setResultMsg(responseRows.statusMsg);
            systemLogModel.setErrorCount(1);

            systemLogModel = systemLogService.save(systemLogModel).entity.get();
            return responseRows;
        }

        return responseRows;
    }
}
