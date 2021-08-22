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

import java.util.ArrayList;
import java.util.List;

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

        SystemLogModel systemLogModel = checkParams(username, createAt, accessCode);
        if (systemLogModel != null) {
            return new ResponseRows<>(systemLogModel.getResultCode(), systemLogModel.getResultMsg());
        }

        ResponseRows<WorkerModel> responseRows = workerService.getWokerStatus(username, createAt, accessCode);
        return responseRows;
    }

    public SystemLogModel checkParams(String username, Long createAt, Integer accessCode) {
        List<SystemLogModel> systemLogModelList = new ArrayList<>();
        if (username == null) {
            SystemLogModel systemLogModel = new SystemLogModel();
            systemLogModel.setCreateAt(createAt);
            systemLogModel.setAdminId("");
            systemLogModel.setAccessCode(accessCode);
            systemLogModel.setResultCode(Const.STATUS_CODE_FAIL_PARAM_NULL);
            systemLogModel.setResultMsg(Utility.getStatusMsg(systemLogModel.getResultCode()) + "username");

            systemLogModel = systemLogService.save(systemLogModel).entity.get();
            return systemLogModel;
        }

        if (username.trim().length() == 0) {
            SystemLogModel systemLogModel = new SystemLogModel();
            systemLogModel.setCreateAt(createAt);
            systemLogModel.setAdminId("");
            systemLogModel.setAccessCode(accessCode);
            systemLogModel.setResultCode(Const.STATUS_CODE_FAIL_PARAM_EMPTY);
            systemLogModel.setResultMsg(Utility.getStatusMsg(systemLogModel.getResultCode()) + "username");

            systemLogModel = systemLogService.save(systemLogModel).entity.get();
            return systemLogModel;
        }

        if (username.trim().length() != 0) {
            if (!Utility.isValidUserName(username)) {
                SystemLogModel systemLogModel = new SystemLogModel();
                systemLogModel.setCreateAt(createAt);
                systemLogModel.setAdminId(username);
                systemLogModel.setAccessCode(accessCode);
                systemLogModel.setResultCode(Const.STATUS_CODE_FAIL_INVALID_USERNAME);
                systemLogModel.setResultMsg(Utility.getStatusMsg(systemLogModel.getResultCode()));

                systemLogModel = systemLogService.save(systemLogModel).entity.get();
                return systemLogModel;
            }
        }

        return null;
    }
}
