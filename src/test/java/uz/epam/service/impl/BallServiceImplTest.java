package uz.epam.service.impl;

import org.testng.annotations.Test;
import uz.epam.domain.Ball;

import static org.testng.Assert.*;

public class BallServiceImplTest {

    @Test
    public void testCreateBall() {

        BallServiceImpl ballService=new BallServiceImpl();
        Ball ball = ballService.createBall();

        assertNotNull(ball);

    }
}