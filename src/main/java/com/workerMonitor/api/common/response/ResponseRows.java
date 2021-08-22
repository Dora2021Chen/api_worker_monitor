package com.workerMonitor.api.common.response;

import java.util.List;

public class ResponseRows<T extends Object> extends Response {
    public List<T> entities;

    public ResponseRows() {
        super();
    }

    public ResponseRows(int statusCode) {
        super(statusCode);
    }

    public ResponseRows(int statusCode, List<T> entities) {
        super(statusCode);
        this.entities = entities;
    }

    public ResponseRows(List<T> entities) {
        super();
        this.entities = entities;
    }

    public ResponseRows(int statusCode, String statusMsg) {
        super(statusCode, statusMsg);
    }

    public ResponseRows(int statusCode, String statusMsg, List<T> entities) {
        super(statusCode, statusMsg);
        this.entities = entities;
    }
}
