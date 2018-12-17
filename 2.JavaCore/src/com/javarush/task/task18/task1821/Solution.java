package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args == null || args.length == 0) return;
        FileInputStream reader = new FileInputStream(args[0]);
        int[] chars = new int[256];

        byte[] buff = new byte[1024];
        //int count = 0;
        while (reader.available() > 0) {
            int count = reader.read(buff);
            for (int i = 0; i < count; i++) {
                chars[buff[i]]++;
            }
        }
        reader.close();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 0) continue;
            System.out.println((char) i + " " + chars[i]);
        }

    }
}
