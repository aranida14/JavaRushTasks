package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int dayNum = Integer.parseInt(s);
        if (dayNum < 1 || dayNum > 7) {
            System.out.println("такого дня недели не существует");
        } else if (dayNum == 1) {
            System.out.println("понедельник");
        } else if (dayNum == 2) {
            System.out.println("вторник");
        } else if (dayNum == 3) {
            System.out.println("среда");
        } else if (dayNum == 4) {
            System.out.println("четверг");
        } else if (dayNum == 5) {
            System.out.println("пятница");
        } else if (dayNum == 6) {
            System.out.println("суббота");
        } else {
            System.out.println("воскресенье");
        }
    }
}