package kz.lesson13;

public interface B extends A{

    default void hello() {
        System.out.println("Hello B");
    }
}
