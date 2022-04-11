package uz.epam.util;

import uz.epam.enums.Colour;

import java.util.Random;

public class Util {

    private static int INDEX;

    public Colour randomColour() {
        Random random = new Random();

        int randomIndex = random.nextInt(4);

        if (checkColourToValidation(randomIndex)) {
            return Colour.values()[randomIndex];
        } else return randomColour();
    }

    public int generateIndex() {
        return ++INDEX;
    }

    public int generateRadius() {
        Random random = new Random();
        int randomRadius = random.nextInt(390);
        if (checkRandomRadiusToValidation(randomRadius)) {
            return randomRadius;
        } else return generateRadius();
    }

    public long generateWeight() {
        Random random = new Random();
        int randomWeight = random.nextInt((650 - 3) + 3);
        if (checkRandomWeightToValidation(randomWeight)) {
            return randomWeight;
        } else return generateRadius();
    }

    public boolean checkColourToValidation(int index) {
        return index >= 0 && index <= Colour.values().length;
    }

    public boolean checkRandomRadiusToValidation(int radius) {
        return radius > 0 && radius < 390;
    }

    public boolean checkRandomWeightToValidation(int weight) {
        return weight > 0 && weight <= 650;
    }

}
