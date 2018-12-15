package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(file1);

        byte[] buffFile1 = new byte[inputStream1.available()];
        int countFile1 = inputStream1.read(buffFile1);
        inputStream1.close();

        FileOutputStream outputStream = new FileOutputStream(file1);
        FileInputStream inputStream2 = new FileInputStream(file2);
        byte[] buffFile2 = new byte[inputStream2.available()];
        int countFile2 = inputStream2.read(buffFile2);
        outputStream.write(buffFile2, 0, countFile2);
        outputStream.write(buffFile1, 0, countFile1);

        outputStream.close();
        inputStream2.close();

    }
}
