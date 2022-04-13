package uz.epam.service.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uz.epam.domain.Ball;
import uz.epam.type.Colour;

import java.util.List;

import static org.testng.Assert.*;

public class BasketServiceImplTest {

    BasketServiceImpl basketService;

    @BeforeMethod
    public void setUp() {
        basketService = new BasketServiceImpl();
    }

    @Test
    public void testCalculateWeightOfBalls() {
        long weight = basketService.calculateWeightOfBalls();
        assertTrue(weight>0);
    }

    @Test
    public void testCountNumberOfBallsByColour() {
        int number = basketService.countNumberOfBallsByColour(Colour.BLACK);
        assertTrue(number>=0);
    }

    @Test
    public void testFillTheBasket() {
        List<Ball> ballList = basketService.fillTheBasket();

        assertNotNull(ballList);
    }

}