package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        ArrayList<String> lines1 = new ArrayList<>();
        ArrayList<String> lines2 = new ArrayList<>();
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in)); BufferedReader
                fileReader1 = new BufferedReader(new FileReader(consoleReader.readLine())); BufferedReader
                     fileReader2 = new BufferedReader(new FileReader(consoleReader.readLine()))) {
            //не знаю, можно ли избежать сохранения файлов в списки
            String line;
            while ((line = fileReader1.readLine()) != null) {
                lines1.add(line);
            }
            while ((line = fileReader2.readLine()) != null) {
                lines2.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //говнокод
        for (int i = 0; i < lines1.size(); ) {
            String line1 = lines1.get(i);
            if (i >= lines2.size()) {
                lines.add(new LineItem(Type.REMOVED, line1));
                i++;
                continue;
            }
            String line2 = lines2.get(i);
            if (line1.equals(line2)) {
                lines.add(new LineItem(Type.SAME, line1));
                i++;
            } else if ((i + 1) < lines2.size() && lines2.get(i + 1).equals(line1)){
                lines.add(new LineItem(Type.ADDED, line2));
                //lines.add(new LineItem(Type.SAME, line1));
                lines2.remove(i);
            } else if ((i + 1) < lines1.size() && lines1.get(i + 1).equals(line2)) {
                lines.add(new LineItem(Type.REMOVED, line1));
                //lines.add(new LineItem(Type.SAME, line2));
                lines2.add(i, "");
                i++;
            } else i++;
        }
        for (int i = lines1.size(); i < lines2.size(); i++) {
            lines.add(new LineItem(Type.ADDED, lines2.get(i)));
        }
        //test
//        for (LineItem li : lines) {
//            System.out.println(li.type + " " + li.line);
//        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
