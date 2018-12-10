package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        byte comma = 0x2C;
        try(FileInputStream inputStream = new FileInputStream(fileName)) {
            if (inputStream.available() > 0) {
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                int count = 0;
                for (int i = 0; i < buffer.length; i++) {
                    if (buffer[i] == comma) count++;
                }
                System.out.println(count);

            }
        }
    }
}
