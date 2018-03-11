package com.rkovtiuk.blog_ms.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Passwords do not match")
public class PasswordDontMatchException extends Exception{

    public PasswordDontMatchException() {
        super("Passwords do not match");
    }

    public PasswordDontMatchException(String s) {
        super(s);
    }

    public PasswordDontMatchException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public PasswordDontMatchException(Throwable throwable) {
        super(throwable);
    }

    public PasswordDontMatchException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
