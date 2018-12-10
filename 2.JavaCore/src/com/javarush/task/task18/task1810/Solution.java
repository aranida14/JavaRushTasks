package com.javarush.task.task18.task1810;

/* 
DownloadException
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = reader.readLine();

            try(FileInputStream inputStream = new FileInputStream(fileName)) {
                if (inputStream.available() < 1000) {
                    reader.close();
                    throw new DownloadException();
                }
            }

        }
        //reader.close();
    }

    public static class DownloadException extends Exception {

    }
}
