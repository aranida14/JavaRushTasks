package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        if (args.length == 0) {
            return;
        }
        if (args[0].equals("-c")) {
            String name = args[1];
            String sex = args[2];
            Date bd = null;
            try {
                bd = inputFormat.parse(args[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Person person = sex.equals("м") ? Person.createMale(name, bd) : Person.createFemale(name, bd);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        } else if (args[0].equals("-u")) {
            int id = Integer.parseInt(args[1]);
            String name = args[2];
            String sex = args[3];
            Date bd = null;
            try {
                bd = inputFormat.parse(args[4]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            allPeople.get(id).setName(name);
            allPeople.get(id).setSex(sex.equals("м") ?  Sex.MALE : Sex.FEMALE);
            allPeople.get(id).setBirthDate(bd);
        } else if (args[0].equals("-d")) {
            int id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDate(null);
        } else if (args[0].equals("-i")) {
            int id = Integer.parseInt(args[1]);
            String name = allPeople.get(id).getName();
            Sex sex = allPeople.get(id).getSex();
            Date bd = allPeople.get(id).getBirthDate();
            System.out.println(name + " " + (sex == Sex.MALE ? "м " : "ж ") + outputFormat.format(bd));
        }
    }
}
