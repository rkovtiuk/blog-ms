package com.rkovtiuk.blog_ms.core.exception;

public class PasswordDontMatch extends Exception{

    public PasswordDontMatch() {
        super("Passwords do not match");
    }

    public PasswordDontMatch(String s) {
        super(s);
    }

    public PasswordDontMatch(String s, Throwable throwable) {
        super(s, throwable);
    }

    public PasswordDontMatch(Throwable throwable) {
        super(throwable);
    }

    public PasswordDontMatch(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
