package com.rkovtiuk.blog_ms.core.exception;

public class EmailNotValidException extends Exception{

    public EmailNotValidException() {
        super("Email not valid exception");
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
