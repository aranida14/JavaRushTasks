package com.javarush.task.task21.task2113;

import java.util.Arrays;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }
    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double maxDist = 0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (horse.getDistance() >= maxDist) {
                maxDist = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.printf("Winner is %s!", getWinner().getName());
    }
    public static void main(String[] args) {
        Horse horse1 = new Horse("Lucky", 3, 0);
        Horse horse2 = new Horse("Baby", 3, 0);
        Horse horse3 = new Horse("Marshmallow", 3, 0);

        game = new Hippodrome(Arrays.asList(horse1, horse2, horse3));
//        System.out.println(game.getHorses());
        game.run();
        game.printWinner();
    }
}
