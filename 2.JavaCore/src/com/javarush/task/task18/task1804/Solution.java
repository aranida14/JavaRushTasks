package com.javarush.task.task18.task1804;

import java.io.*;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }

        HashMap<Integer, Long> map = new HashMap<>(256);
        try(FileInputStream inputStream = new FileInputStream(fileName)) {
            //if (!(inputStream.available() > 0)) return;
            while (inputStream.available() > 0) {
                int b = inputStream.read();

                map.putIfAbsent(b, 0L);
                map.put(b, map.get(b) + 1);
            }
        }
        //check
//        for (int i = 0; i < byteArr.length; i++) {
//            System.out.println(byteArr[i]);
//        }
        if (map.isEmpty()) return;
        long min = Collections.min(map.values());
        for (Map.Entry<Integer, Long> entry: map.entrySet()) {
            if (entry.getValue() == min) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
