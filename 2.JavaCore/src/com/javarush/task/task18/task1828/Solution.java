package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        if (args.length < 2) return;
        ArrayList<String> prices = new ArrayList<>();
        String fileName = "";
        try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in)); BufferedReader
                fileReader = new BufferedReader(new FileReader(fileName = consoleReader.readLine()))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                prices.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(args[1]);

        for (int i = 0; i < prices.size(); i++) {
            int idTmp = Integer.parseInt(prices.get(i).substring(0, 8).trim());
            if (id == idTmp) {
                if (args[0].equals("-u")) {
                    String productName = args[2].length() > 30 ? args[2].substring(0, 30) : args[2];
                    String price = args[3].length() > 8 ? args[3].substring(0, 8) : args[3];
                    String quantity = args[4].length() > 4 ? args[4].substring(0, 4) : args[4];
                    String product = String.format("%1$-8s%2$-30s%3$-8s%4$-4s", Integer.toString(id), productName, price,
                            quantity);
                    prices.set(i, product);
                } else if (args[0].equals("-d")) {
                    prices.remove(i);
                }
                break;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : prices) {
                writer.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
