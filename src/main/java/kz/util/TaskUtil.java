package kz.util;

import kz.model.apple.Apple;
import kz.model.apple.Color;
import kz.model.dish.Dish;
import kz.model.dish.Type;
import kz.model.trader.Trader;
import kz.model.trader.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class TaskUtil {
    public static List<Apple> getApples() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(getRandomEnumConstant(Color.class), getRandomInt(1,10)));
        apples.add(new Apple(getRandomEnumConstant(Color.class), getRandomInt(1,10)));
        apples.add(new Apple(getRandomEnumConstant(Color.class), getRandomInt(1,10)));
        apples.add(new Apple(getRandomEnumConstant(Color.class), getRandomInt(1,10)));

        return apples;
    }


    public static <T extends Enum<?>> T getRandomEnumConstant(Class<T> enumClass) {
        if (enumClass == null || !enumClass.isEnum()) {
            throw new IllegalArgumentException("Class is not an Enum type");
        }

        T[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null || enumConstants.length == 0) {
            throw new IllegalArgumentException("Enum has no constants");
        }

        int randomIndex = new Random().nextInt(enumConstants.length);
        return enumConstants[randomIndex];
    }

    private static int getRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range");
        }

        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }


    public static List<Dish> getDish() {
        List<Dish> dishes = new ArrayList<>();
        Random random = new Random();
        dishes.add(new Dish("pork", false, 800, Type.MEAT));
        dishes.add(new Dish("beef", false, 700, Type.MEAT));
        dishes.add(new Dish("chicken", false, 400, Type.MEAT));
        dishes.add(new Dish("french", true, 530, Type.OTHER));
        dishes.add(new Dish("rice", true, 350, Type.OTHER));
        dishes.add(new Dish("season", true, 120, Type.OTHER));
        dishes.add(new Dish("pizza", true, 550, Type.OTHER));
        dishes.add(new Dish("prawns", false, 300, Type.FISH));
        dishes.add(new Dish("salmon", false, 450, Type.FISH));
        return dishes;
    }

    public static List<Integer> getRandomIntList() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(2);
        integers.add(4);
        integers.add(6);
        integers.add(2);
        integers.add(87);
        return integers;
    }

    public static List<Transaction> getTransactions() {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }











}
