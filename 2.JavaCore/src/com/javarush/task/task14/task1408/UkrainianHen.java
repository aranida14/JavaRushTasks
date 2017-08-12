package com.javarush.task.task14.task1408;

/**
 * Created by Dinara Ibragimova on 12.08.2017.
 */
public class UkrainianHen extends Hen {

    public int getCountOfEggsPerMonth() {
        return 80;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
