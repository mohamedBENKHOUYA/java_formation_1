package com.unionistashop.crud_app_1.exceptions;

import java.util.ArrayList;

public class ExceptionBody {

    private int status;
    private ArrayList<String> messages;
    private long timeStamp;

    public ExceptionBody(HttpException httpException) {

    }

    public ExceptionBody(int status, ArrayList<String> messages, long timeStamp) {
        this.status = status;
        this.messages = messages;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
