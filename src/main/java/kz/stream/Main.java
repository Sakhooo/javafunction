package kz.stream;

import kz.model.dish.Dish;
import kz.util.TaskUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {


        basik();
        stream();

        //takeWhile
        takeWhileAndDropWHile();
        List<Dish> dishes = TaskUtil.getDish();

        limit(dishes);
        skip(dishes);
        map(dishes);
        flatMap(dishes);


        exampleMap();

        find(dishes);



    }

    private static void find(List<Dish> dishes) {
            if (dishes.stream().anyMatch(Dish::isVegetarian)) {
                System.out.println("yes");
            }

        boolean b = dishes.stream()
                .allMatch(dish -> dish.getCalories() < 1000);

        boolean b1 = dishes.stream().noneMatch(dish -> dish.getCalories() >= 1000);

        Optional<Dish> any = dishes.stream()
                .filter(dish -> dish.isVegetarian())
                .findAny();
        any.ifPresent(System.out::println);



    }

    private static void exampleMap() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .map(integer -> integer*integer)
                .collect(toList());

        List<Integer> list2 = Arrays.asList(1, 2, 3);
        List<Integer> list3 = Arrays.asList(3, 4);

        List<int[]> collect = list2.stream()
                .flatMap(i -> list3.stream().map(j -> new int[]{i, j}))
                .collect(toList());

        list2.stream()
                .flatMap(i -> list3.stream()
                        .filter(j-> (i+j)%3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(toList());



    }

    private static void flatMap(List<Dish> dishes) {

        String[] arrayOfWords = {"Goodbye", "World"};
        List<String> streamOfwords = Arrays.asList(arrayOfWords);


        List<String[]> collect1 = streamOfwords.stream()
                .map(s -> s.split(""))
                .distinct()
                .collect(toList());


        List<Stream<String>> collect = streamOfwords.stream()
                .map(s -> s.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        List<String> collect2 = streamOfwords.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());


    }

    private static void map(List<Dish> dishes) {
        dishes.stream().map(Dish::getName).collect(toList());
        dishes.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());



        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        words.stream().map(String::length).collect(toList());

    }

    private static void skip(List<Dish> dishes) {
        dishes.stream().skip(4).collect(toList());
    }

    private static void limit(List<Dish> dishes) {
        dishes.stream().limit(5).collect(toList());
    }

    private static void stream() {
        List<Dish> dishes = TaskUtil.getDish();
        List<String> lowCaloricName = dishes.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }

    private static void takeWhileAndDropWHile() {
        //takeWhile если отсортирован он останавливается если 320
        List<Dish> dishes = TaskUtil.getDish();
        dishes.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList());

        //dropWhile он боле 320 выбирает
        dishes.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
    }

    private static void basik() {
        List<Dish> dishes = TaskUtil.getDish();


        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getCalories().compareTo(o2.getCalories());
            }
        });

        List<String> lowCaloricName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricName.add(dish.getName());
        }
    }
}
