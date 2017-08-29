package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        String url = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            url = reader.readLine();
        } catch(IOException e) {
            System.out.println(e);
        }
        if (url != null && !url.isEmpty()) {
            String obj = null;
            String[] parameters = url.split("\\?")[1].split("&"); //массив параметров - название и значение

            for (String param : parameters) {
                String[] paramKeyVal = param.split("="); //массив из макс. 2 значений, где 1-е - имя параметра, 2-е - его значение
                System.out.print(paramKeyVal[0].concat(" ")); //выводим имя параметра
                if (paramKeyVal.length > 1 && paramKeyVal[0].equals("obj")) { //проверка, есть ли значение у параметра с именем "obj"
                    obj = paramKeyVal[1];
                }
            }
            System.out.println();
            if (obj != null && isDouble(obj)) {
                alert(Double.parseDouble(obj));
            } else if (obj != null) {
                alert(obj);
            }
        }

    }
    //isDouble - функция проверяет, является ли строка числом типа double
    public static boolean isDouble(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
