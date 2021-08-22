package com.workerMonitor.api.common.response;

public class Response {
    public int statusCode;  //0:succeed, 1000:fail
    public String statusMsg;

    public Response() {
        this(Const.STATUS_CODE_SUCCEED);
    }

    public Response(int statusCode) {
        this.statusCode = statusCode;
        this.statusMsg = Const.STATUS_MAP.get(this.statusCode);
    }

    public Response(int statusCode, String statusMsg) {
        this(statusCode);
        if (statusMsg != null && statusMsg.length() > 0) {
            StringBuilder statusMsgBuilder = new StringBuilder();
            statusMsgBuilder.append(this.statusMsg).append(": ").append(statusMsg);
            this.statusMsg = statusMsgBuilder.toString();
        }
    }

    public Response(Response response) {
        this.statusCode = response.statusCode;
        this.statusMsg = response.statusMsg;
    }
}
