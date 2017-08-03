package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(breader.readLine());
        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                even += 1;
            } else {
                odd += 1;
            }
            number /= 10;
        }
        System.out.println("Even: " + even +" Odd: " + odd);
    }
}
