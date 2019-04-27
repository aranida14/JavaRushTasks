package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        // 0..9 - цифра, 10..35 - заглавные латинские буквы, 36..61 - строчные латинские буквы
        String passUnits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        char[] pass = new char[8];

        String stringPass;
        do {
            for (int i = 0; i < 8; i++) {
                pass[i] = passUnits.charAt(random.nextInt(62));
            }
            stringPass = new String(pass);
//            System.out.println(stringPass);
        } while (!(stringPass.matches(".*[A-Z]+.*") && stringPass.matches(".*[a-z]+.*") && stringPass.matches(".*\\d+.*")));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(stringPass.getBytes());
        } catch (IOException e) {
            System.err.println("Writing to byteArrayOutputStream failed!");
        }
        return baos;
    }
}