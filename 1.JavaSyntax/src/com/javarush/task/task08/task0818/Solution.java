package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Иванов", 1000);
        map.put("Петров", 500);
        map.put("Сидоров", 300);
        map.put("Богатов", 5000);
        map.put("Скородумов", 2000);
        map.put("Тихонов", 499);
        map.put("Горцев", 1200);
        map.put("Васнецов", 450);
        map.put("Луганский", 4000);
        map.put("Шомов", 700);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> mapCopy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : mapCopy.entrySet()) {
            if (pair.getValue() < 500) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
//        HashMap<String, Integer> map = Solution.createMap();
//        System.out.println(map);
//        Solution.removeItemFromMap(map);
//        System.out.println(map);
    }
}