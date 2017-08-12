package com.javarush.task.task14.task1409;

/**
 * Created by Dinara Ibragimova on 12.08.2017.
 */
public class WaterBridge implements Bridge {
    private static int carsCount = 1000;
    @Override
    public int getCarsCount() {
        return carsCount;
    }
}
