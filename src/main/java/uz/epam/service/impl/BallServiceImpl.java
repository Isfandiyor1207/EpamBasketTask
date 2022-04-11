package uz.epam.service.impl;

import uz.epam.domain.Ball;
import uz.epam.service.BallService;
import uz.epam.util.Util;

public class BallServiceImpl implements BallService {

    @Override
    public Ball createBall() {

        Ball ball = new Ball();

        Util util = new Util();

        ball.setId(util.generateIndex());
        ball.setRadius(util.generateRadius());
        ball.setWeight(util.generateWeight());
        ball.setColour(util.randomColour());

        return ball;
    }


}
