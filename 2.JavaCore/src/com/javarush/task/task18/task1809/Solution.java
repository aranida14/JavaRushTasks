package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        reader.close();
        byte[] buffer;
        if (inputStream.available() > 0) {
            buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            //System.out.println(count);
            byte[] reversedBuffer = new byte[count];
            for (int i = 0; i < count; i++) {
                reversedBuffer[i] = buffer[count - i - 1];
                //System.out.println(reversedBuffer[i]);
            }
            outputStream.write(reversedBuffer);
        }
        inputStream.close();
        outputStream.close();

    }
}
