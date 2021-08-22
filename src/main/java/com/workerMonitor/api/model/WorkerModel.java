package com.workerMonitor.api.model;

import javax.persistence.*;

@Entity
@Table(name = "worker")
public class WorkerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getCreateAt() {
        return createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Integer getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(Integer accessCode) {
        this.accessCode = accessCode;
    }

    @Column(nullable = false)
    private Long createAt;  //milliseconds

    @Column(nullable = false)
    private Integer workerId;

    @Column(nullable = false)
    private Integer accessCode;

    @Column(nullable = false)
    private String workerName;

    @Column(nullable = false)
    private String cpuUsage;

    @Column(nullable = false)
    private String ramUsage;

    @Column(nullable = false)
    private String vmemUsage;

    @Column(nullable = true)
    private String gpuUsage;

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(String cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public String getRamUsage() {
        return ramUsage;
    }

    public void setRamUsage(String ramUsage) {
        this.ramUsage = ramUsage;
    }

    public String getVmemUsage() {
        return vmemUsage;
    }

    public void setVmemUsage(String vmemUsage) {
        this.vmemUsage = vmemUsage;
    }

    public String getGpuUsage() {
        return gpuUsage;
    }

    public void setGpuUsage(String gpuUsage) {
        this.gpuUsage = gpuUsage;
    }
}
