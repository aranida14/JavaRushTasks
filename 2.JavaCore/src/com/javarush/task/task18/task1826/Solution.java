package com.javarush.task.task18.task1826;

/* 
Шифровка
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) {

        try(FileInputStream inputStream = new FileInputStream(args[1]); FileOutputStream outputStream = new
                FileOutputStream(args[2])) {
            byte[] buff = new byte[2 * 1024];
            while (inputStream.available() > 0) {
                int readCount = inputStream.read(buff);
                for (int i = 0; i < readCount; i++) {
                    buff[i] = (byte) (buff[i] ^ 0xFF);
                }
                outputStream.write(buff, 0, readCount);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
