package se.iths.viggo.dicegame;

import java.util.Random;

public class Dice {
    final static Random random = new Random();

    public static int roll() {
        return random.nextInt(1, 7);
    }
}
