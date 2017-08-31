package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 2;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут

            while (!currentThread().isInterrupted()) {
                if (countSeconds >= 1) {
                    System.out.print(countSeconds-- + " ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
//                        e.printStackTrace();
                        System.out.print("Прервано!");
                        return;
                    }
                } else {
                    System.out.print("Марш!");
                    return;
                }
            }
            System.out.print("Прервано!");
        }
    }
}
