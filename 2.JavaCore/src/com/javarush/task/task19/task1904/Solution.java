package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
        //test
//        try {
//            Scanner sc = new Scanner(new FileInputStream("D:\\Java\\file1.txt"));
//            PersonScanner personScanner = new PersonScannerAdapter(sc);
//            System.out.println(personScanner.read());
//            System.out.println(personScanner.read());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
            // Person(String firstName, String middleName, String lastName, Date birthDate)
            // Иванов Иван Иванович 31 12 1950
            String[] personItems = line.split(" ", 4);
            String fisrtName = personItems[1];
            String middleName = personItems[2];
            String lastName = personItems[0];
            String birthDateStr = personItems[3];
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date birthDate = null;
            try {
                birthDate = format.parse(birthDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return new Person(fisrtName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
