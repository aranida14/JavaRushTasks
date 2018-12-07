package com.javarush.task.task18.task1805;

import java.io.*;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        byte[] byteArr = new byte[256];
        try(FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                int readByte = inputStream.read();
                byteArr[readByte] = 1;
            }
        }
        for (int i = 0; i < byteArr.length; i++) {
            if (byteArr[i] != 0) {
                System.out.print(i + " ");
            }
        }

    }
}
