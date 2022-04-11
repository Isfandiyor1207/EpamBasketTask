package uz.epam.domain;

import uz.epam.enums.Colour;

import java.util.Objects;
import java.util.StringJoiner;

public class Ball {

    private int id;
    private int radius;
    private long weight;
    private Colour colour;

    public Ball() {
    }

    public Ball(int id, int radius, long weight, Colour colour) {
        this.id = id;
        this.radius = radius;
        this.weight = weight;
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return id == ball.id && radius == ball.radius && weight == ball.weight && colour == ball.colour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, radius, weight, colour);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ball.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("radius=" + radius)
                .add("weight=" + weight)
                .add("colour=" + colour)
                .toString();
    }
}