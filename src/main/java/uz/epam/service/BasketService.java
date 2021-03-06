package uz.epam.service;

import uz.epam.domain.Ball;
import uz.epam.type.Colour;

import java.util.List;

public interface BasketService {

    long calculateWeightOfBalls();

    int countNumberOfBallsByColour(Colour colour);

    List<Ball> fillTheBasket();
}
