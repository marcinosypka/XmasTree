package com.xmastree.draw;

import static com.xmastree.CharacterPrinter.printCharacter;
import static com.xmastree.CharacterPrinter.printTreeCharacter;

public class DrawLeftXmasTree implements DrawXmasTreeStrategy {

    public void drawXmasTree(int size, int segments) {

        for (int i = 0; i < size; i++) {
            drawLine(size, segments, i);
        }
        for (int i = size; i >= 0; i--) {
            drawLine(size, segments, i);
        }
    }

    private void drawLine(int size, int segments, int i) {
        for (int j = 0; j < segments; j++) {
            drawBranch(size, i);
        }
        printCharacter("\n", 1);
    }

    private static void drawBranch(int size, int i) {
        printCharacter(" ", size - i);
        printTreeCharacter("*", i);
    }
}
