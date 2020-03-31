package lk.uwu.grocery.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Manula Uluwatta on 1/22/2020.
 */
public class Validator {
    public static Boolean isNotEmpty(String[] values) {

        if (values == null || values.length == 0) {
            return Boolean.TRUE;
        }

        for (String value : values) {
            if (!isNotEmpty(value)) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    public static Boolean isNotEmpty(String value) {

//        return (value==null || value.trim().isEmpty()) ? Boolean.FALSE : Boolean.TRUE;
//        return (value==null || value.trim().isEmpty()) ? "validation fail" : "Validation OK";
        if (value == null || value.trim().isEmpty()) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }
    public static boolean isAlpha(String value){
        String ePattern="[a-zA-Z_]+";
        Pattern p=Pattern.compile(ePattern);
        Matcher m=p.matcher(value);
        return m.matches();
    }

    public static boolean isNumber(String number){
        String ePattern="[0-9]+";
        Pattern p=Pattern.compile(ePattern);
        Matcher m=p.matcher(number);
        return m.matches();
    }

    public static boolean isPhoneNumber(String number) {
        String ePattern = "^\\d{10}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(number);
        return m.matches();
    }

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    public static boolean validateNIC(String nic) {
        String ePattern="^(\\d{9}|\\d{12})[VvXx]$";
        Pattern p=Pattern.compile(ePattern);
        Matcher m=p.matcher(nic);
        return m.matches();
    }
}
