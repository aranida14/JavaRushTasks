package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        if (args == null || args.length == 0) return;
        FileInputStream inputStream = new FileInputStream(args[0]);
        //if (inputStream.available() <= 0) return;

        byte[] buff = new byte[1000];
        int counter = 0;
        while (inputStream.available() > 0) {
            int buffCount = inputStream.read(buff);
            for (int i = 0; i < buffCount; i++) {
                char aByte = (char)buff[i];
                if (aByte >= 'A' && aByte <= 'Z' || aByte >= 'a' && aByte <= 'z') {
                    counter++;
                }
            }
        }
        System.out.println(counter);
        inputStream.close();
    }
}
