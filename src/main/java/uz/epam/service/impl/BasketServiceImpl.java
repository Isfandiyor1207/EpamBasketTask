package uz.epam.service.impl;

import uz.epam.domain.Ball;
import uz.epam.type.Colour;
import uz.epam.service.BasketService;

import java.util.ArrayList;
import java.util.List;

public class BasketServiceImpl implements BasketService {

    @Override
    public long calculateWeightOfBalls() {
        FileServiceImpl fileService = new FileServiceImpl();
        List<Ball> ballList = fileService.readFromFile();
        if (ballList == null) {
            throw new RuntimeException("There isn`t any balls.");
        }
        return ballList.stream().mapToLong(Ball::getWeight).sum();
    }

    @Override
    public int countNumberOfBallsByColour(Colour colour) {

        FileServiceImpl fileService=new FileServiceImpl();
        List<Ball> ballList=fileService.readFromFile();

        if (ballList == null) {
            throw new RuntimeException("There isn`t any balls.");
        }

        return (int) ballList.stream().filter(ball -> ball.getColour() == colour).count();
    }

    @Override
    public List<Ball> fillTheBasket() {
        BallServiceImpl ballService = new BallServiceImpl();

        List<Ball> ballList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Ball ball = ballService.createBall();
            ballList.add(ball);
        }

        return ballList;
    }


}
