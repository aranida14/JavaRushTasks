package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
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
        //seek(long pos), read(byte[] b, int off, int len), write(byte[] b)
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            raf.seek(position);
            byte[] buff = new byte[text.getBytes("UTF-8").length];
            raf.read(buff, 0, buff.length);
            String textFromFile = new String(buff, "UTF-8");
            raf.seek(raf.length());
            if (text.equals(textFromFile)) {
                raf.write("true".getBytes("UTF-8"));
            } else {
                raf.write("false".getBytes("UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
