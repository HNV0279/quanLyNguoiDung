package com.QuanLyNguoiDung.QuanLyNguoiDung.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private int statusCode;
    private String message;
    private Object content;
    private String dateTime;
    private String messageConstants;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessageConstants() {
        return messageConstants;
    }

    public void setMessageConstants(String messageConstants) {
        this.messageConstants = messageConstants;
    }
}
