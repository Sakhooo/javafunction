package kz.optional;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Optional<Car> car = Optional.empty();
        Car car1 = null;
        Optional<Car> optCar = Optional.of(car1);
        Optional<Car> optCar2 = Optional.ofNullable(car1);

        Insurance insurance = new Insurance();
        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        Optional<String> name2 = optionalInsurance.map(Insurance::getName);

        Person person = new Person();
        Optional<Person> optPerson = Optional.of(person);
        Optional<String> name =
                optPerson.flatMap(Person::getCar)
                        .flatMap(Car::getInsurance)
                        .map(Insurance::getName);
    }

    public Set<String> getCarInsuranceNames(List<Person> persons) {
        return persons.stream()
                .map(Person::getCar)
                .map(car -> car.flatMap(Car::getInsurance))
                .map(insurance -> insurance.map(Insurance::getName))
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());
    }


    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
//        if (person.isPresent() && car.isPresent()) {
//            return Optional.of(findCheapestInsurance(person.get(), car.get()));
//        } else {
//            return Optional.empty();
//        }

        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    private Insurance findCheapestInsurance(Person person, Car car) {
        return null;
    }


    private void filterOptional(Optional<Insurance> insurance) {
        insurance.filter(insurance1 -> "CampridgeInsrurace".equals(insurance1.getName())).ifPresent(System.out::println);
    }

    public String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(person1 -> person1.age >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }

    }


    public int readDuration(Properties properties , String name) {
        return Optional.ofNullable(properties.get(name)).flatMap(key -> stringToInt(key.toString())).filter(i-> i>0).orElse(0);
    }


}
