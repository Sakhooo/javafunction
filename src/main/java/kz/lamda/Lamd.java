package kz.lamda;

import kz.model.apple.Apple;

import java.nio.file.DirectoryStream;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lamd {
    public static void main(String[] args) {
        Function<String, Integer> stringIntegerFunction = (String s) -> s.length();
        DirectoryStream.Filter<Apple> appleFilter = (Apple a) -> a.getWeight() > 15;
        Callable callable;
        Predicate predicate;
    }
}
