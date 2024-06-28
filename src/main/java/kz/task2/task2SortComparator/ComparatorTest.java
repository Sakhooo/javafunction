package kz.task2.task2SortComparator;

import kz.model.apple.Apple;
import kz.model.apple.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static kz.util.TaskUtil.getApples;

public class ComparatorTest {
    public static void main(String[] args) {
        List<Apple> inventar = getApples();
        inventar.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });


        inventar.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));



    }
}
