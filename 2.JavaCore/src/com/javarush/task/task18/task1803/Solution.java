package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        try(FileInputStream inputStream = new FileInputStream(fileName)) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            while (inputStream.available() > 0) {
                int readByte = inputStream.read();
                Integer val = map.get(readByte);
                if (val == null) {
                    map.put(readByte, 1);
                } else {
                    map.put(readByte, ++val);
                }
            }
            List<Map.Entry<Integer, Integer> > list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
            Collections.sort(list, Collections.reverseOrder(new Comparator<Map.Entry<Integer, Integer> >() {
                public int compare(Map.Entry<Integer, Integer> o1,
                                   Map.Entry<Integer, Integer> o2)
                {
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            }));
            HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
            int maxFrequency = 0;
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    maxFrequency = list.get(i).getValue();
                    System.out.print(list.get(i).getKey() + " ");
                    //для проверки
                    //System.out.print((char)list.get(i).getKey().byteValue() + " ");
                } else if (list.get(i).getValue() == maxFrequency) {
                    System.out.print(list.get(i).getKey() + " ");
                    //для проверки
                    //System.out.print((char)list.get(i).getKey().byteValue() + " ");
                } else {
                    break;
                }
            }


        }
    }
}
