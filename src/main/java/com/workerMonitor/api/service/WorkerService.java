package com.workerMonitor.api.service;

import com.workerMonitor.api.common.response.ResponseRows;
import com.workerMonitor.api.model.WorkerModel;
import com.workerMonitor.api.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public ResponseRows<WorkerModel> getWokerStatus() {
        ResponseRows<WorkerModel> responseRows = new ResponseRows<>();

        List<WorkerModel> workerModelList = getCurrentWorkerStatus();

        workerModelList = workerRepository.saveAll(workerModelList);

        responseRows.entities = workerModelList;

        return responseRows;
    }

    public List<WorkerModel> getCurrentWorkerStatus() {
        List<WorkerModel> workerModelList = new ArrayList<>();
        Long createAt = System.currentTimeMillis();
        WorkerModel workerModel0 = new WorkerModel();
        workerModel0.setWorkerId(0);
        workerModel0.setWorkerName("host p2_pc");
        workerModel0.setCreateAt(createAt);
        workerModel0.setCpuUsage("0 core(s) in use");
        workerModel0.setRamUsage("1% 1.726 GiB/125.9 GiB");
        workerModel0.setVmemUsage("0% 1.726% GiB/261.9 GiB");
        workerModel0.setGpuUsage("GeForce RTX 2070, not used");
        workerModelList.add(workerModel0);

        WorkerModel workerModel1 = new WorkerModel();
        workerModel1.setWorkerId(1);
        workerModel1.setWorkerName("host p1_01");
        workerModel1.setCreateAt(createAt);
        workerModel1.setCpuUsage("3 core(s) in use");
        workerModel1.setRamUsage("17% 174.3 GiB/996 GiB");
        workerModel1.setVmemUsage("13% 198.3% GiB/1.473 GiB");
        workerModelList.add(workerModel1);

        WorkerModel workerModel2 = new WorkerModel();
        workerModel2.setWorkerId(2);
        workerModel2.setWorkerName("host p2_00");
        workerModel2.setCreateAt(createAt);
        workerModel2.setCpuUsage("32 core(s) in use");
        workerModel2.setRamUsage("3% 37.32 GiB/1008 GiB");
        workerModel2.setVmemUsage("10% 157.3 GiB/1.485 TiB");
        workerModel2.setGpuUsage("GeForce RTX 2080 Ti, not used");
        workerModelList.add(workerModel2);

        WorkerModel workerModel5 = new WorkerModel();
        workerModel5.setWorkerId(5);
        workerModel5.setWorkerName("host filecoin");
        workerModel5.setCreateAt(createAt);
        workerModel5.setCpuUsage("48 core(s) in use");
        workerModel5.setRamUsage("13% 32.55 GiB/224 GiB");
        workerModel5.setVmemUsage("43% 152.6 GiB/352 GiB");
        workerModel5.setGpuUsage("GeForce RTX 1080 Ti, not used");
        workerModelList.add(workerModel5);

        return workerModelList;
    }
}
