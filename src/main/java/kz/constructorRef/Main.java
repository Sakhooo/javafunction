package kz.constructorRef;

import kz.model.apple.Apple;
import kz.model.apple.Color;
import kz.model.apple.Fruit;
import kz.model.apple.Orange;
import kz.util.TaskUtil;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);

        Function<Integer, Apple> function = Apple::new;


        List<Apple> apples = map(weights, Apple::new);


        BiFunction<Color, Integer, Apple> biFunction = Apple::new;
        BiFunction<Color, Integer, Apple> biFunction2 = (c, i) -> new Apple(c, i);

        Fruit apple = giveMeFruit("Apple", 23);
        System.out.println(apple);

        List<Apple> apples1 = TaskUtil.getApples();
        apples1.sort(Comparator.comparing(Apple::getWeight).reversed());

        Predicate<Apple> redApple = apple1 -> apple1.getColor() == Color.RED;

        Function<Integer, Apple> appleFunction = Apple::new;

        Function<Integer, Integer> e = x -> x + 1;
        Function<Integer, Integer> e2 = x -> x * 2;
        Function<Integer, Integer> e3 = e.andThen(e2);
        Function<Integer, Integer> e4 = e.compose(e2);
        e3.apply(3);


        //Все бы хорошо, но что, если вам попадутся два яблока одинакового веса? Какое из
        //них должно идти первым в отсортированном списке?

        apples1.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));

    }


    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();


    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }


    public static Fruit giveMeFruit(String fruit, Integer weight) {
        return map.get(fruit.toLowerCase()).apply(weight);
    }




    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> apples = new ArrayList<>();
        for (Integer i : list) {
            apples.add(f.apply(i));
        }
        return apples;
    }


}
