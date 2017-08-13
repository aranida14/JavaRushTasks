package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        // 2nd
        try {
            Object o = null;
            o.getClass();

        } catch (Exception e) {
            exceptions.add(e);
        }
        // 3rd
        try {
            Object s = "1";
            ((List) s).isEmpty();

        } catch (Exception e) {
            exceptions.add(e);
        }
        // 4th
        try {
            FileInputStream inputStream = new FileInputStream("incorrectFileName");

        } catch (Exception e) {
            exceptions.add(e);
        }
        //5th
        try {
            int[] array = {1, 2, 3};
            for (int i = 0; i < 4; i++) {
                array[i]++;
            }

        } catch (Exception e) {
            exceptions.add(e);
        }
        //6th
        try {
            Exception e = new TimeoutException();
            throw e;

        } catch (Exception e) {
            exceptions.add(e);
        }
        //7th
        try {
            List<String> list = new ArrayList<>();
            list.add("first");
            list.get(1);

        } catch (Exception e) {
            exceptions.add(e);
        }
        //8th
        try {
            throw new IllegalAccessException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        //9th
        try {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        //10th
        try {
            throw new InstantiationException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
