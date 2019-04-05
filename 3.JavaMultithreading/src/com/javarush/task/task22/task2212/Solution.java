package com.javarush.task.task22.task2212;

import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
//        Matcher telMatcher = Pattern.compile("").matcher(telNumber);
//        if (telNumber == null)
        if ((telNumber == null) || telNumber.isEmpty()
                || telNumber.matches(".*-{2,}.*") ||
                telNumber.split("")[telNumber.length() - 1].matches("\\D") || !telNumber.replaceAll("[-()]", "")
                .matches("^(\\+\\d{12})|(\\d{10})") || telNumber.matches(".*-.*[()].*") || telNumber.matches("" +
                ".*\\).*\\(.*") || telNumber.matches(".*\\(\\d{0,2}\\).*") || telNumber.replaceAll("[^-]", "").matches
                ("-{3,}")) {
            return false;
        }

        return true;
//        return Pattern.matches("^(\\+\\d{2})?(\\d{10}|(\\(\\d{3}\\)\\d{7})|\\d{6}-\\d{2}-\\d{2}|\\d{6}-\\d{4})$",
//                telNumber);
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber(null)); //false
        System.out.println(checkTelNumber("+380501234567")); //true
        System.out.println(checkTelNumber("+38(050)1234567")); //true
        System.out.println(checkTelNumber("+38050123-45-67")); //true
        System.out.println(checkTelNumber("050123-4567")); //true
        System.out.println(checkTelNumber("+38)050(1234567")); //false
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7")); //false
        System.out.println(checkTelNumber("050ххх4567")); //false
        System.out.println(checkTelNumber("050123456")); //false
        System.out.println(checkTelNumber("(0)501234567")); //false
    }
}
