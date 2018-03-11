package com.rkovtiuk.blog_ms.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Non authorized user")
public class AuthorizedException extends Exception{

    public AuthorizedException() {
        super("Non authorized user");
    }

    public AuthorizedException(String s) {
        super(s);
    }

    public AuthorizedException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public AuthorizedException(Throwable throwable) {
        super(throwable);
    }

    protected AuthorizedException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
