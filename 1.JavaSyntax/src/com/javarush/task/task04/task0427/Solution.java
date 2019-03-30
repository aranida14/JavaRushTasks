package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int inNumber = scanner.nextInt();
        if (inNumber >= 1 && inNumber <= 999) {
            if (isEven(inNumber) && numLength(inNumber) == 1)
                System.out.println("четное однозначное число");
            else if (numLength(inNumber) == 1)
                System.out.println("нечетное однозначное число");
            else if (isEven(inNumber) && numLength(inNumber) == 2)
                System.out.println("четное двузначное число");
            else if (numLength(inNumber) == 2)
                System.out.println("нечетное двузначное число");
            else if (isEven(inNumber) && numLength(inNumber) == 3)
                System.out.println("четное трехзначное число");
            else if (numLength(inNumber) == 3)
                System.out.println("нечетное трехзначное число");
        }
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

    private static int numLength(int n) {
        return String.valueOf(n).length();
    }

}
