package com.rkovtiuk.blog_ms.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Wrong password or email")
public class WrongPassOrEmailException extends Exception{

    public WrongPassOrEmailException() {
        super("Wrong password or email");
    }

    public WrongPassOrEmailException(String s) {
        super(s);
    }

    public WrongPassOrEmailException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public WrongPassOrEmailException(Throwable throwable) {
        super(throwable);
    }

    public WrongPassOrEmailException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
