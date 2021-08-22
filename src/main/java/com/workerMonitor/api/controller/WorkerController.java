package com.workerMonitor.api.controller;

import com.workerMonitor.api.common.response.Const;
import com.workerMonitor.api.common.response.ResponseRows;
import com.workerMonitor.api.model.WorkerModel;
import com.workerMonitor.api.service.WorkerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workerMonitor/worker")
public class WorkerController {
    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping(path = "findAll", produces = Const.RESPONSE_FORMAT)
    public ResponseRows<WorkerModel> findAll() {
        ResponseRows<WorkerModel> responseRows = workerService.getWokerStatus();
        return responseRows;
    }
}
