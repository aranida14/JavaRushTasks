package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consoleOut);

        String[] resultComponents = outputStream.toString().split(" ");
        int first = Integer.parseInt(resultComponents[0]);
        int second = Integer.parseInt(resultComponents[2]);

        switch (resultComponents[1]) {
            case "+":
                System.out.println(outputStream.toString().replace(System.lineSeparator(), "") + (first + second));
                break;
            case "-":
                System.out.println(outputStream.toString().replace(System.lineSeparator(), "") + (first - second));
                break;
            case "*":
                System.out.println(outputStream.toString().replace(System.lineSeparator(), "") + (first * second));
                break;

        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

