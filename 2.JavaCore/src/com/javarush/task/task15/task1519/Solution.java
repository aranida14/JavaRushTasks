package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;


/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код


        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = reader.readLine();
            if ("exit".equals(s)) {
                break;
            }
            list.add(s);
        }

        for (String s :list) {
            if (isDouble(s) && s.contains(".")) {
                print(Double.parseDouble(s));
            } else if (isInt(s) && Integer.parseInt(s) > 0 && Integer.parseInt(s) < 128) {
                print((short) Integer.parseInt(s));
            } else if (isInt(s)) {
                print(Integer.parseInt(s));
            } else {
                print(s);
            }
        }
    }

    //isDouble
    public static boolean isDouble(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
    //isInt
    public static boolean isInt(String str)
    {
        try
        {
            double d = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
