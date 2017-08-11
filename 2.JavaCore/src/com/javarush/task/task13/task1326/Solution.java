package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        reader.close();
        ArrayList<Integer> evenList = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(fName)))) {
            while (r.ready()) {
                String s = r.readLine();
                int n = Integer.parseInt(s);
                if (n % 2 == 0) {
                    evenList.add(n);
                }
            }

            Collections.sort(evenList);
            for (int i : evenList) {
                System.out.println(i);
            }
        }

    }
}
