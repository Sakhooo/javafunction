package kz.stream;

import kz.model.dish.Dish;
import kz.util.TaskUtil;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapToSimple {
    public static void main(String[] args) {
        List<Dish> dishes = TaskUtil.getDish();
        int sum = dishes.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        long count = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0).count();


        int[] ints = {3, 4, 5};
        Arrays.stream(ints).filter(b -> Math.sqrt(b*b) % 1 == 0);

        Stream.iterate(new int[] {0,1},
                t-> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t-> System.out.println("(" + t[0] + "," + t[1] +")"));


        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);


        System.out.println("\n");


//        IntStream.iterate(0, n -> n + 4)
//                .filter(n -> n < 100)
//                .forEach(System.out::println);

        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);


        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            public int getAsInt(){
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);


    }
}
