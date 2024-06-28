package kz.task2;

import kz.model.apple.Apple;
import kz.model.apple.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Task2 {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(Color.BLUE, 13));
        apples.add(new Apple(Color.RED, 16));
        apples.add(new Apple(Color.BLUE, 17));
        apples.add(new Apple(Color.RED, 12));

        prettyPrintApple(apples, new AppleFancyFormatter());


    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

}
