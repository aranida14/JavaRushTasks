package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileName1, fileName2, fileName3 = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            fileName3 = reader.readLine();
        }
        try(
                FileInputStream inputStream = new FileInputStream(fileName1);
                FileOutputStream outputStream1 = new FileOutputStream(fileName2);
                FileOutputStream outputStream2 = new FileOutputStream(fileName3);
            ){
            if (inputStream.available() > 0) {
                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);
                int off = (count % 2 == 0)? count/2 : count/2 + 1;
                outputStream1.write(buffer, 0, off);
                outputStream2.write(buffer, off, count - off);
            }
        }
    }
}
