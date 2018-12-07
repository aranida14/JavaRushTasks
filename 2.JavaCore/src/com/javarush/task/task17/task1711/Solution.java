package com.javarush.task.task17.task1711;

import java.text.*;
import java.util.*;


/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (args.length < 1) {
            return;
        }
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; (i + 2) < args.length; i = i + 3) {
                        String name = args[i];
                        String sex = args[i + 1];
                        Date bd = null;
                        try {
                            bd = inputFormat.parse(args[i + 2]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Person person = sex.equals("м") ? Person.createMale(name, bd) : Person.createFemale(name, bd);
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                        //для отладки:
                        //System.out.println(person.toString());
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; (i + 3) < args.length; i = i + 4) {
                        int id = Integer.parseInt(args[i]);
                        String name = args[i + 1];
                        String sex = args[i + 2];
                        Date bd = null;
                        try {
                            bd = inputFormat.parse(args[i + 3]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        allPeople.get(id).setName(name);
                        allPeople.get(id).setSex(sex.equals("м") ?  Sex.MALE : Sex.FEMALE);
                        allPeople.get(id).setBirthDate(bd);
                        //для отладки:
                        //System.out.println(allPeople.get(id).toString());
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDate(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        String name = allPeople.get(id).getName();
                        Sex sex = allPeople.get(id).getSex();
                        Date bd = allPeople.get(id).getBirthDate();
                        System.out.println(name + " " + (sex == Sex.MALE ? "м " : "ж ") + outputFormat.format(bd));
                    }
                }
                break;
        }
    }
}
