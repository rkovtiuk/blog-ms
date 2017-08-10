package com.rkovtiuk.blog_ms.core.utils;

public class Validator {

    static public boolean isEmpty(String str) {
        return str == null || "".equals(str);
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
