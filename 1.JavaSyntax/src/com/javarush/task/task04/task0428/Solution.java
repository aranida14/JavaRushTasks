package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        byte count = 0;
        for (int i = 0; i < 3; i++) {
            int num = scanner.nextInt();
            if (num > 0) {
                count++;
            }
        }
        System.out.println(count);

    }
}
