package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        try(FileInputStream inputStream = new FileInputStream(fileName)) {
            int minByte;
            if (inputStream.available() > 0) {
                minByte = inputStream.read();
            } else {
                return;
            }
            while (inputStream.available() > 0) {
                int readByte = inputStream.read();
                if (readByte < minByte) {
                    minByte = readByte;
                }
            }
            System.out.println(minByte);
        }
    }
}
