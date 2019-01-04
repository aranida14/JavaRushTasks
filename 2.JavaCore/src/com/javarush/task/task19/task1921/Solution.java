package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        if (args.length < 1) return;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] items = line.split("(?<!\\d)\\s+(?=\\d)");
                String name = items[0];
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d M yyyy");
                Date birthDate = null;
                try {
                    birthDate = simpleDateFormat.parse(items[1]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                PEOPLE.add(new Person(name, birthDate));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //test
        /*
        Iterator<Person> iterator = PEOPLE.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person.getName() + " " + person.getBirthDate());
        }
        */
    }
}
