package kz.lesson13;

public interface A {
    default void hello() {
        System.out.println("hello A");
    }
}

