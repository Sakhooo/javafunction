package kz.lamdaType;

import kz.model.apple.Apple;
import kz.util.TaskUtil;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.ToIntFunction;

public class Exe1 {
    public static void main(String[] args) {
        Comparator<Apple> apples = (Apple a, Apple a1) -> a.getWeight().compareTo(a1.getWeight());
        Comparator<Apple> apples2 = (a, a1) -> a.getWeight().compareTo(a1.getWeight());

        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);

        Comparator<Apple> comparing = Comparator.comparing(Apple::getWeight);

        List<Apple> apples1 = TaskUtil.getApples();
        apples1.sort(comparing);
//
//        BiFunction<Exe1, String, Boolean> isValidName = Exe1::isValidName;
//        "".compareToIgnoreCase()


        ToIntFunction<String> stringToInt = Integer::parseInt;
        BiPredicate<List<String>, String> biPredicate = List::contains;


    }

    public boolean isValidName(String s) {
        return Character.isUpperCase(0);
    }
}
