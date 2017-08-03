package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        int shortest, longest;
        int shortestInd, longestInd;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s);
        }
        shortest = list.get(0).length();
        shortestInd = 0;
        longest = list.get(0).length();
        longestInd = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() < shortest) {
                shortest = list.get(i).length();
                shortestInd = i;
            } else if (list.get(i).length() > longest) {
                longest = list.get(i).length();
                longestInd = i;
            }
        }
        if (shortestInd < longestInd) {
            System.out.println(list.get(shortestInd));
        } else {
            System.out.println(list.get(longestInd));
        }
    }
}
