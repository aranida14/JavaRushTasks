package com.javarush.task.task18.task1817;

/* 
Пробелы
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args == null || args.length == 0) return;
        FileInputStream inputStream = new FileInputStream(args[0]);

        byte[] buff = new byte[1000];
        int counterAll = 0;
        int counterSpace = 0;
        while (inputStream.available() > 0) {
            int buffCount = inputStream.read(buff);
            counterAll += buffCount;
            for (int i = 0; i < buffCount; i++) {
                char aByte = (char)buff[i];
                if (aByte == ' ') {
                    counterSpace++;
                }
            }
        }
        System.out.println(Math.round(100.0 * 100 * counterSpace / counterAll) / 100.0);
        inputStream.close();
    }
}
