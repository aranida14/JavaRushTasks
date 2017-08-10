package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String s = rd.readLine();
        BufferedWriter wr = new BufferedWriter(new FileWriter(s));
        while (!"exit".equals(s)) {
            s = rd.readLine();
            wr.write(s + "\n" );
            wr.flush();
        }
        wr.close();
        rd.close();
    }
}
