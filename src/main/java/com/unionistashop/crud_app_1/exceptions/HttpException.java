package com.unionistashop.crud_app_1.exceptions;

public class HttpException extends RuntimeException{
    private int status;
    private long timeStamp;

    public HttpException(int status, String message, long timeStamp) {
        super(message);
        this.status = status;
        this.timeStamp = timeStamp;
    }
    public HttpException(int status, String message) {
        super(message);
        this.status = status;
        this.timeStamp = System.currentTimeMillis();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
