package uz.epam.service.impl;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uz.epam.domain.Ball;

import java.util.List;

import static org.testng.Assert.*;

public class FileServiceImplTest {

    FileServiceImpl fileService;

    @BeforeClass
    public void setUp(){
        fileService=new FileServiceImpl();
    }

    @Test
    public void testReadFromFile() {
        List<Ball> ballList = fileService.readFromFile();
        assertNotNull(ballList);
    }
}