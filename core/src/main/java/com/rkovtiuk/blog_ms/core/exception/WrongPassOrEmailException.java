package com.rkovtiuk.blog_ms.core.exception;

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
