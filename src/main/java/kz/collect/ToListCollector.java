package kz.collect;

import kz.model.dish.Dish;
import kz.util.TaskUtil;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    //создает новый лист
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    //Добавляет лст новыми элементам
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    // он распаралить данные и в конце собирает потоков
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    //в конце завершает все
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    //Последний из методов, characteristics, возвращает неизменяемый набор типа
    //Characteristics, который определяет поведение коллектора — в частности, предо-
    //ставляет «подсказки» относительно того, можно ли выполнять свертку параллельно
    //и какие оптимизации допустимы при этом. Characteristics — перечисляемый тип,
    //содержащий три элемента.
    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>() {
            {add(Characteristics.IDENTITY_FINISH);add(Characteristics.CONCURRENT);}
        };
    }

    public static void main(String[] args) {

        Collections.emptyList();

        List<Dish> menu = TaskUtil.getDish();

        ToListCollector<Dish> collector = new ToListCollector<>();
        List<Dish> dishes = collector.supplier().get();
        for (Dish dish : menu) {
            collector.accumulator().accept(dishes, dish);
        }
        List<Dish> apply = collector.finisher().apply(dishes);
        System.out.println(apply);
        System.out.println("fbxcJIA3 :: " + new HashSet<>(apply).containsAll(menu));


        menu.stream().collect(Collectors.toList());

    }


}
