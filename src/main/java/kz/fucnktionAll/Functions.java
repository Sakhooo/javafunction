package kz.fucnktionAll;

import java.util.Random;
import java.util.function.*;

public class Functions {
    public static void main(String[] args) {
        //Predicate
        // Predicate<T>          T -> boolean
        IntPredicate intPredicate = new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value % 2 == 0;
            }
        };

        LongPredicate longPredicate = new LongPredicate() {
            @Override
            public boolean test(long value) {
                return value % 2 == 0;
            }
        };

        DoublePredicate doublePredicate = new DoublePredicate() {
            @Override
            public boolean test(double value) {
                return value % 2 == 0;
            }
        };

        //Consumer
        // Consumer<T>          T -> void

        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        };

        LongConsumer longConsumer = new LongConsumer() {
            @Override
            public void accept(long value) {
                System.out.println(value);
            }
        };

        DoubleConsumer doubleConsumer = new DoubleConsumer() {
            @Override
            public void accept(double value) {
                System.out.println(value);
            }
        };

        //Function
        // Function<T, R>          T -> R

        IntFunction<String> intFunction = new IntFunction<String>() {
            @Override
            public String apply(int value) {
                return "count : " + value;
            }
        };

//        Supplier<T>  () -> T
        BooleanSupplier booleanSupplier = new BooleanSupplier() {
            @Override
            public boolean getAsBoolean() {
                Random random = new Random();
                return random.nextBoolean();
            }
        };
//        UnaryOperator<T>   T -> T

        IntUnaryOperator intUnaryOperator = new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                Random random = new Random();
                return operand + random.nextInt();
            }
        };
//        BinaryOperator<T>     (T, T) -> T

        IntBinaryOperator intBinaryOperator = new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        };

//        BiPredicate<T, U>       (T, U) -> boolean


        BiPredicate<String, Boolean> biPredicate = new BiPredicate<String, Boolean>() {
            @Override
            public boolean test(String s, Boolean aBoolean) {
                return aBoolean;
            }
        };

//        BiConsumer<T, U>      (T, U) -> void

        ObjIntConsumer<Integer> objIntConsumer = new ObjIntConsumer<Integer>() {
            @Override
            public void accept(Integer integer, int value) {
                System.out.println(integer + value);
            }
        };

//        BiFunction<T, U, R>      (T, U) -> R

        ToIntBiFunction<String, Boolean> toIntBiFunction = new ToIntBiFunction<String, Boolean>() {
            @Override
            public int applyAsInt(String s, Boolean aBoolean) {
                return aBoolean ? s.length() : 0;
            }
        };
















    }

}
