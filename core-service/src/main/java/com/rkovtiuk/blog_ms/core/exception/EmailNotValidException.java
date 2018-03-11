package com.rkovtiuk.blog_ms.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Email is not valid")
public class EmailNotValidException extends Exception{

    public EmailNotValidException() {
        super("Email is not valid");
    }

    public EmailNotValidException(String s) {
        super(s);
    }

    public EmailNotValidException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public EmailNotValidException(Throwable throwable) {
        super(throwable);
    }

    public EmailNotValidException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
