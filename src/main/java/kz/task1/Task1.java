package kz.task1;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Apple apple = new Apple(5);
        Apple apple2 = new Apple(2);
        Apple apple23 = new Apple(3);
        Apple apple24 = new Apple(1);
        Apple apple25 = new Apple(6);

        List<Apple> apples = new ArrayList<>();
        apples.add(apple);
        apples.add(apple2);
        apples.add(apple24);
        apples.add(apple23);
        apples.add(apple25);

        Collections.sort(apples, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        apples.sort(Comparator.comparing(Apple::getWeight));



    }
}
