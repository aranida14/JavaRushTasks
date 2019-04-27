package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        if (args.length < 3) return;
        String fileName = args[0];
        long position;
        String text = args[2];

        try {
            position = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("args[1] is not a number: " + args[1]);
            return;
        }
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            if (position > raf.length()) {
                position = raf.length();
            }
            raf.seek(position);
            raf.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
