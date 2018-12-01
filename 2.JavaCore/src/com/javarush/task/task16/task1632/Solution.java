package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        //System.out.println("inside static block");
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }
    public static void main(String[] args) {
//        for (int i = 0; i < threads.size(); i++) {
//            threads.get(i).start();
//            System.out.println("started thread " + threads.get(i).getName());
//        }
//        System.out.println("thread 4 alive? " + threads.get(3).isAlive());
//
//        if (threads.get(3) instanceof Thread4) {
//            Thread4 t4 = (Thread4) threads.get(3);
//            t4.showWarning();
//            System.out.println("thread 4 interrupted?" + t4.isInterrupted());
//            System.out.println("thread 4 alive? " + t4.isAlive());
//        }
    }

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            int i = 0;
            while (true) {
                //System.out.println(i);
            }
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message{
        @Override
        public void run() {
            while (!isInterrupted()) {}
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class Thread5 extends Thread {
        @Override
        public void run() {
            int sum = 0;
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String snum = "";
                while (reader.ready()) {
                    snum = reader.readLine();
                    if (snum.equals("N")) {
                        break;
                    }
                    sum += Integer.parseInt(snum);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println(sum);
            }
        }
    }
}