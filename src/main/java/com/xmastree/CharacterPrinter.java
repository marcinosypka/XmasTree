package com.xmastree;

import java.util.Random;

public class CharacterPrinter {

    private final static String GREEN = "\u001B[32m";
    private final static String RED = "\u001B[31m";
    private final static String RESET = "\u001B[0m";
    private static Random randomGenerator = new Random(23);

    public static void printCharacter(String character, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(character);
        }
    }

    public static void printTreeCharacter(String character, int count) {

        for (int andrzej = 0; andrzej < count; andrzej++) {
            if (!isBauble()) {
                System.out.print(GREEN + character);
            } else {
                System.out.print(RED + "o" + GREEN);
            }
        }
    }

    private static Boolean isBauble() {
        int value = randomGenerator.nextInt(100);
        return value < 10;
    }
}
