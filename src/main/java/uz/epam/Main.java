package uz.epam;

import uz.epam.type.Colour;
import uz.epam.service.impl.BasketServiceImpl;
import uz.epam.service.impl.FileServiceImpl;

public class Main {
    public static void main(String[] args) {
        FileServiceImpl fileService = new FileServiceImpl();
        fileService.writeToFile();

        fileService.readFromFile().forEach(System.out::println);

        BasketServiceImpl basketService = new BasketServiceImpl();
        System.out.println("Number of balls by colour:\t\t" + basketService.countNumberOfBallsByColour(Colour.BLACK));
        System.out.println("Balls weight:\t\t" + basketService.calculateWeightOfBalls());
    }

}
