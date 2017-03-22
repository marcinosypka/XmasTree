package com.xmastree.draw;

import static com.xmastree.CharacterPrinter.printCharacter;
import static com.xmastree.CharacterPrinter.printTreeCharacter;


public class DrawUpXmasTree implements DrawXmasTreeStrategy {

    public void drawXmasTree(int size, int segments) {
        for (int j = 0; j < segments; j++) {
            drawSegment(size);
        }

    }

    private void drawSegment(int size) {
        for (int i = 0; i < size; i++) {
            drawBranch(size, i);
        }
    }

    private void drawBranch(int size, int i) {
        printCharacter(" ", size - i - 1);
        printTreeCharacter("*", 2 * i + 1);
        printCharacter("\n", 1);
    }


}
