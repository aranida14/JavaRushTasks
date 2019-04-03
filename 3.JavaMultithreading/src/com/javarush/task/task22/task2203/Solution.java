package com.javarush.task.task22.task2203;

import java.util.Arrays;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{

        try {

            String[] words = string.split("\\t", -1);
            if (words.length -1 < 2)
                throw new TooShortStringException();
//            System.out.println(Arrays.toString(words));
            return words[1];
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
