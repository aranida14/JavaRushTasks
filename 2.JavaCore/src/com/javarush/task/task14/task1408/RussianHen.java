package com.javarush.task.task14.task1408;

/**
 * Created by Dinara Ibragimova on 12.08.2017.
 */
public class RussianHen extends Hen {

    public int getCountOfEggsPerMonth() {
        return 100;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
