package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        int n1 = 0, n2 = 0;

        n1 = Integer.parseInt(s1);
        n2 = Integer.parseInt(s2);
        if (n1 <= 0 || n2 <= 0) throw new Exception("input number is not a positive int");
        reader.close();
        while (n1 > 0 && n2 > 0) {
            if (n1 > n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }
        System.out.println(n1 + n2);
    }
}
