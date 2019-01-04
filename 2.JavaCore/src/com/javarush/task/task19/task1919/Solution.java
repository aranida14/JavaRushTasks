package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        if (args.length < 1) return;
        TreeMap<String, Double> salaries = new TreeMap<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] items = line.split(" ");
                String name = items[0];
                Double salary = Double.parseDouble(items[1]);
                salaries.put(name, salaries.getOrDefault(name, 0.0) + salary);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Double> entry : salaries.entrySet()) {
            System.out.printf("%s %s%n", entry.getKey(), entry.getValue());
        }
    }
}
