package com.example.railways.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserCreateUtils {
    public static boolean regexCheck(String regex, String text) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean isEmailAddressValid(String emailAddress) {
        return regexCheck("^[A-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[A-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[A-Z0-9-]+(?:\\.[A-Z0-9-]+)*$", emailAddress);
    }

    public static boolean isPasswordValid(String password) {
        return regexCheck("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", password);
    }
}
