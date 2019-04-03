package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString(null));
    }

    public static String getPartOfString(String string) {
        if (string == null)
            throw new TooShortStringException();
        int beginIndex;
        if (string.indexOf(" ") != -1) {
            beginIndex = string.indexOf(" ") + 1;
        } else {
            throw new TooShortStringException();
        }

        int spaceCounter = 0;
        int currIndex = 0;
        while (spaceCounter < 4) {
            int spaceIndex = string.indexOf(" ", currIndex);
            if (spaceIndex == -1)
                throw new TooShortStringException();
            currIndex = spaceIndex + 1;
//            System.out.println(currIndex);
            spaceCounter++;
        }
        if (string.length() == currIndex)
            throw new TooShortStringException();

        int endIndex;
        if (string.indexOf(" ", currIndex) == -1) {
            endIndex = string.length();
        } else {
            endIndex = string.indexOf(" ", currIndex);
        }
        String res;
        try {
            res = string.substring(beginIndex, endIndex);
        } catch (StringIndexOutOfBoundsException e) {
            throw new TooShortStringException();
        }
        return res;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
