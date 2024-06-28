package kz.model.dish;

public class Dish {
    private Integer calories;
    private String name;
    private Type type;
    private boolean vegetarian;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Dish(String name, boolean vegetarian, Integer calories, Type type) {
        this.calories = calories;
        this.name = name;
        this.type = type;
        this.vegetarian = vegetarian;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "calories=" + calories +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", vegetarian=" + vegetarian +
                '}';
    }
}
