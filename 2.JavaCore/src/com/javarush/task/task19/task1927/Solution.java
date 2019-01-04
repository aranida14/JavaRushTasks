package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        testString.printSomething();
        StringBuilder result = new StringBuilder();
        String contextAdv = "JavaRush - курсы Java онлайн";
        String[] lines = byteArrayOutputStream.toString().split(System.lineSeparator());
        for (int i = 0; i < lines.length; i++) {
            result.append(lines[i]).append(System.lineSeparator());
            if ((i + 1) % 2 == 0) {
                result.append(contextAdv).append(System.lineSeparator());
            }
        }
        System.setOut(consoleOut);
        System.out.println(result.delete(result.lastIndexOf(System.lineSeparator()), result.length()).toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
