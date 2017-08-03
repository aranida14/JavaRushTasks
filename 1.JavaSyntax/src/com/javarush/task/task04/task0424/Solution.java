package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());
        int n3 = Integer.parseInt(reader.readLine());
        if (n1 == n2 && n1 != n3) {
            System.out.println(3);
        } else if (n1 == n3 && n1 != n2) {
            System.out.println(2);
        } else if (n2 == n3 && n1 != n2) {
            System.out.println(1);
        }
    }
}
