package kz.task6;

import kz.model.dish.CaloricLevel;
import kz.model.dish.Dish;
import kz.model.dish.Type;
import kz.model.trader.Transaction;
import kz.util.TaskUtil;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static kz.util.TaskUtil.*;

public class Example1 {
    public static void main(String[] args) {

        Map<Currency, Transaction> transactionByCurrencies = new HashMap<>();
        List<Transaction> transactions = getTransactions();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
        }

        List<Dish> menu = getDish();


        Map<Type, List<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType));


        Map<CaloricLevel, List<Dish>> collect1 = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }));




        Long count = menu.stream().collect(Collectors.counting());
        Optional<Dish> max = menu.stream().collect(maxBy(comparingInt(Dish::getCalories)));
        Optional<Dish> min = menu.stream().collect(minBy(comparingInt(Dish::getCalories)));
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        double avgCalories =
                menu.stream().collect(averagingInt(Dish::getCalories));

        IntSummaryStatistics menuStatistics =
                menu.stream().collect(summarizingInt(Dish::getCalories));

        String joining = menu.stream().map(Dish::getName).collect(joining());
        String shortMenu2 = menu.stream().map(Dish::getName).collect(joining(", "));

        int totalCalories2 = menu.stream().collect(reducing(
                0, Dish::getCalories, (i, j) -> i + j));

        Map<Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));


        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                } ));

        Map<Type, List<Dish>> caloricDishesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                filtering(dish -> dish.getCalories() > 500, toList())));

        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));

        Map<Type, Set<String>> dishNamesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                flatMapping(dish -> dishTags.get( dish.getName() ).stream(),
                                        toSet())));

    }

}
