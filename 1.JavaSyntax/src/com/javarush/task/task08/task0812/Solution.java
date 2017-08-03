package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(reader.readLine());
            list.add(n);
        }
        // 2 2 4 4 4
        int len = 1;
        int tempLen = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i+1).equals(list.get(i))) {
                tempLen++;
            } else {
                if (tempLen > len) {
                    len = tempLen;
                }
                tempLen = 1;
            }
        }
        if (tempLen > len) {
            len = tempLen;
        }
        System.out.println(len);

    }
}