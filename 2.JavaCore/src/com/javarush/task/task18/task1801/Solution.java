package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }

        FileInputStream inputStream = new FileInputStream(fileName);
        int maxByte;
        if (inputStream.available() > 0) {
            maxByte = inputStream.read();
        } else {
            inputStream.close();
            return;
        }
        while (inputStream.available() > 0) {
            int b;
            if ((b = inputStream.read()) > maxByte) {
                maxByte = b;
            }
        }
        inputStream.close();
        System.out.println(maxByte);

    }
}
