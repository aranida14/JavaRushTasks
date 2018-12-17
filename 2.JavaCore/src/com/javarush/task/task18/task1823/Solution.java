package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName;
            while (!(fileName = reader.readLine()).equals("exit")) {
                ReadThread readThread = new ReadThread(fileName);
                readThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*for (Map.Entry<String, Integer> e : resultMap.entrySet()) { //todo for test only
            System.out.println(e.getKey() + " " + e.getValue());
        }*/
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try(FileInputStream inputStream = new FileInputStream(fileName)) {
                int[] bytesFrequency = new int[256];
                byte[] buff = new byte[2048];
                while (inputStream.available() > 0) {
                    int count = inputStream.read(buff);
                    for (int i = 0; i < count; i++) {
                        bytesFrequency[buff[i]]++;
                    }
                }
                int maxFrequency = bytesFrequency[0];
                int maxFrIndex = 0;
                for (int i = 1; i < bytesFrequency.length ; i++) {
                    if (bytesFrequency[i] > maxFrequency) {
                        maxFrequency = bytesFrequency[i];
                        maxFrIndex = i;
                    }
                }
                if (maxFrequency != 0) {
                    synchronized (Solution.resultMap) {
                        resultMap.put(fileName, maxFrIndex);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
