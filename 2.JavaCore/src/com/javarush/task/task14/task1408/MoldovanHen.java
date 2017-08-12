package com.javarush.task.task14.task1408;

/**
 * Created by Dinara Ibragimova on 12.08.2017.
 */
public class MoldovanHen extends Hen {

    public int getCountOfEggsPerMonth() {
        return 90;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
