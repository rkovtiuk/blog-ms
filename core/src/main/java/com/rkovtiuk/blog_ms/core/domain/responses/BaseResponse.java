package com.rkovtiuk.blog_ms.core.domain.responses;

import java.io.Serializable;

public class BaseResponse implements Serializable{

    private String message;

    public BaseResponse() {
    }

    public BaseResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
