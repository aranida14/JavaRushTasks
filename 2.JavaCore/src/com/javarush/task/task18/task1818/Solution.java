package com.javarush.task.task18.task1818;

/* 
Два в одном
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        FileInputStream inputStream1 = new FileInputStream(reader.readLine());
        FileInputStream inputStream2 = new FileInputStream(reader.readLine());

        byte[] buffer = new byte[1000];
        while (inputStream1.available() > 0) {
            //System.out.println("reading inputStream1");
            int count = inputStream1.read(buffer);
            outputStream.write(buffer, 0, count);
        }

        while (inputStream2.available() > 0) {
            //System.out.println("reading inputStream2");
            int count = inputStream2.read(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        inputStream1.close();
        inputStream2.close();
    }

}
