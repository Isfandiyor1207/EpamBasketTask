package uz.epam.service;

import uz.epam.domain.Ball;

import java.util.List;

public interface FileService {

    String createFile();

    void writeToFile();

    List<Ball> readFromFile();

}
