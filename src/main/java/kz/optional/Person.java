package kz.optional;

import java.util.Optional;

public class Person {
    private Optional<Car> car;
    public int age;
    public Optional<Car> getCar() {
        return car;
    }
}
