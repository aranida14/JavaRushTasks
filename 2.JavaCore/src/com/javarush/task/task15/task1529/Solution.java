package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
        String s;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s = reader.readLine();
            if ("helicopter".equals(s)) {
                result = new Helicopter();
            }
            if ("plane".equals(s)) {
                s = reader.readLine();
                try {
                result = new Plane(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
