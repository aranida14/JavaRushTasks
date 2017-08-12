package com.javarush.task.task14.task1413;

/**
 * Created by Dinara Ibragimova on 13.08.2017.
 */
public class Monitor implements CompItem {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
