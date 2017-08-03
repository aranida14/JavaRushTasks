package com.javarush.task.task01.task0130;

/* 
Наш первый конвертер!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertCelsiumToFahrenheit(40));
    }

    public static double convertCelsiumToFahrenheit(int celsium) {
        //напишите тут ваш код
        double fahrenheit = celsium * 9 / 5.0 + 32;
        return fahrenheit;
        // TC = (TF – 32) * 5/9
        // TC*9/5 = TF - 32
        // TF = 9/5*TC + 32
    }
}