package com.javarush.task.task20.task2002;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("task2002File", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User()); //1

            User user = new User(); //2
            user.setFirstName("Лиза");
            user.setLastName("Иванова");
            user.setBirthDate(new Date());
            user.setMale(false);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user); //2 end

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            //System.out.println(loadedObject.users.toString());
            System.out.println("javaRush is equal to loadedObject: " + javaRush.equals(loadedObject));
            System.out.println("hashcodes are equal: " + (javaRush.hashCode() == loadedObject.hashCode()));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(users.size());
            for (User user : users) {
                String isFirstNamePresent = user.getFirstName() != null ? "yes" : "no";
                printWriter.println(isFirstNamePresent);
                if (isFirstNamePresent.equals("yes")) {
                    printWriter.println(user.getFirstName());
                }

                String isLastNamePresent = user.getLastName() != null ? "yes" : "no";
                printWriter.println(isLastNamePresent);
                if (isLastNamePresent.equals("yes")) {
                    printWriter.println(user.getLastName());
                }

                printWriter.println(user.getBirthDate() != null ? user.getBirthDate().getTime() : "null");
                printWriter.println(user.isMale());
                printWriter.println(user.getCountry() != null ? user.getCountry().getDisplayName() : "null");
            }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int usersSize = Integer.parseInt(reader.readLine());
            for (int i = 0; i < usersSize; i++) {
                User user = new User();
                String isFirstNamePresent = reader.readLine();
                if (isFirstNamePresent.equals("yes")) {
                    user.setFirstName(reader.readLine());
                }
                String isLastNamePresent = reader.readLine();
                if (isLastNamePresent.equals("yes")) {
                    user.setLastName(reader.readLine());
                }
                String birthDateMillis = reader.readLine();
                if (!birthDateMillis.equals("null")) {
                    user.setBirthDate(new Date(Long.parseLong(birthDateMillis)));
                }
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                String country = reader.readLine();
                if (!country.equals("null")) {
                    user.setCountry(User.Country.valueOf(country.toUpperCase()));
                    /*switch (country) {
                        case "Ukraine":
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        case "Russia":
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        case "Other":
                            user.setCountry(User.Country.OTHER);
                    }*/

                }
                this.users.add(user);
            }
            reader.close();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
