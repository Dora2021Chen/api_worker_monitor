package com.workerMonitor.api.common.response;

import java.util.Optional;

public class ResponseRow<T extends Object> extends Response {
    public Optional<T> entity;

    public ResponseRow() {
        super();
    }

    public ResponseRow(int statusCode) {
        super(statusCode);
    }

    public ResponseRow(int statusCode, Optional<T> entity) {
        super(statusCode);
        this.entity = entity;
    }

    public ResponseRow(Optional<T> entity) {
        super();
        this.entity = entity;
    }

    public ResponseRow(T entity) {
        super();
        this.entity = Optional.of(entity);
    }

    public ResponseRow(int statusCode, String statusMsg) {
        super(statusCode, statusMsg);
    }

    public ResponseRow(int statusCode, String statusMsg, Optional<T> entity) {
        super(statusCode, statusMsg);
        this.entity = entity;
    }

    public ResponseRow(Response response) {
        super(response);
    }
}
