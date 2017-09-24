package com.rkovtiuk.blog_ms.core.utils;

import java.lang.reflect.Field;
import java.util.Optional;

public class Validator {

    public static boolean isEmpty(Object obj) {
        if (obj == null) return true;
        if (obj instanceof String) return "".equals((String) obj);
        return !(obj instanceof Integer) || ((Integer) obj) == 0;
    }

    public static boolean isObjectEmpty(Object obj) {
        if (obj == null) return true;
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Optional<Object> value = getValue(field, obj);
            if (!value.isPresent())
                return true;
        }
        return false;
    }

    private static Optional<Object> getValue(Field field, Object object) {
        Optional<Object> value = Optional.empty();
        try {
            value = Optional.ofNullable(field.get(object));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isActiveToken(long tokenDate, long nowDate, long tokenLifeTime){
        return tokenDate+tokenLifeTime > nowDate;
    }

}
