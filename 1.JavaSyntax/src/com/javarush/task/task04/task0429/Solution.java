package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        byte posCount = 0;
        byte negCount = 0;

        for (int i = 0; i < 3; i++) {
            int num = scanner.nextInt();
            if (num > 0) {
                posCount++;
            } else if (num < 0) {
                negCount++;
            }
        }
        System.out.println("количество отрицательных чисел: " + negCount);
        System.out.println("количество положительных чисел: " + posCount);
    }
}
