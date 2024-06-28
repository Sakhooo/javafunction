package kz.model.apple;

public class Orange extends Fruit{
    Color color;
    Integer weight;

    public Orange(Color color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public Orange(Integer weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "color=" + color +
                ", weight=" + weight +
                '}';
    }
}
