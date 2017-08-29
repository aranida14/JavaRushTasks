package com.javarush.task.task15.task1529;

/**
 * Created by Dinara Ibragimova on 29.08.2017.
 */
public class Plane implements Flyable {
    public int passengers;

    public Plane(int passengers) {
        this.passengers = passengers;
    }
    @Override
    public void fly() {
    }
}
