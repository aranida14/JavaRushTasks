package com.javarush.task.task15.task1530;

/**
 * Created by Dinara Ibragimova on 29.08.2017.
 */
public class TeaMaker extends DrinkMaker {

    /*
    «Заливаем кипятком»
«Берем чашку для латте»
«Насыпаем чай»
«Берем чашку для чая»
«Заливаем молоком с пенкой»
«Делаем кофе«
     */

    @Override
    void getRightCup() {
        System.out.println("Берем чашку для чая");
    }

    @Override
    void putIngredient() {
        System.out.println("Насыпаем чай");
    }

    @Override
    void pour() {
        System.out.println("Заливаем кипятком");
    }
}
