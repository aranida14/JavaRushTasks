package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double t = Double.parseDouble(reader.readLine());
        double r = t % 5;
        if (r >= 0 && r < 3) {
            System.out.println("зелёный");
        } else if (r >= 3 && r < 4) {
            System.out.println("желтый");
        } else {
            System.out.println("красный");
        }
    }
}