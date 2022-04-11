package uz.epam.domain;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Basket {

    private List<Ball> ballList;

    public Basket() {
    }

    public Basket(List<Ball> ballList) {
        this.ballList = ballList;
    }

    public List<Ball> getBallList() {
        return ballList;
    }

    public void setBallList(List<Ball> ballList) {
        this.ballList = ballList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(ballList, basket.ballList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballList);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Basket.class.getSimpleName() + "[", "]")
                .add("ballList=" + ballList)
                .toString();
    }
}
