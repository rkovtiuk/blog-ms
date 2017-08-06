package com.rkovtiuk.blog_ms.db.domain.auth_role;

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
