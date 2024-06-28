package kz.stream;

import kz.model.dish.Dish;
import kz.util.TaskUtil;

import java.util.List;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {
        List<Integer> randomIntList = TaskUtil.getRandomIntList();

        int sum = 0;
        for (Integer i : randomIntList) {
            sum += i;
        }

        Integer reduce = randomIntList.stream().reduce(0, (a, b) -> a + b);
        Integer reduce2 = randomIntList.stream().reduce(0, Integer::sum);
        Optional<Integer> reduce3 = randomIntList.stream().reduce(Integer::sum);
        Optional<Integer> reduce4 = randomIntList.stream().reduce(Integer::min);
        Optional<Integer> reduce5 = randomIntList.stream().reduce(Integer::max);


        List<Dish> dishes = TaskUtil.getDish();
        Integer dish = dishes.stream().map(d -> 1).reduce(0, Integer::sum);

        long count = dishes.stream().count();


    }
}
