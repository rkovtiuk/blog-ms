package com.rkovtiuk.blog_ms.auth.domain.models;

public enum UserField {
    USER_NAME("username");

    private final String field;

    UserField(String field) {
        this.field = field;
    }

    public String field(){
        return field;
    }

}
