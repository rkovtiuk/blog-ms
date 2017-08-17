package com.rkovtiuk.blog_ms.core.exception;

public class AuthorizedException extends Exception{

    public AuthorizedException() {
        super("Non Authorized User");
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
