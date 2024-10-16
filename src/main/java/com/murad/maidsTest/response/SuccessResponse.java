package com.murad.maidsTest.response;

import java.util.List;


public class SuccessResponse {

    public SuccessResponse(String message, Object data) {
        super();
        this.message = message;
        this.data = data;
    }

    private String message;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}