package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream
                ("D:/Java/javarushForTests/secretPasswords.txt"));
        System.out.println(writer.toString());

        StringWriter writer1 = getAllDataFromInputStream(null);
        System.out.println("\"" + writer1.toString() + "\"");

    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        if (is == null) return sw;
        byte[] buff = new byte[1024];
        int count;
        while ((count = is.read(buff)) != -1) {
            sw.write(new String(buff, 0, count, "UTF-8"));
        }
        return sw;
    }
}