package com.xmastree;

import static com.xmastree.CharacterPrinter.printCharacter;
import static com.xmastree.CharacterPrinter.printTreeCharacter;

public class DrawDownXmasTree implements DrawXmasTreeStrategy {
    @Override
    public void drawXmasTree(int size, int segments) {
        for (int j = 0; j < segments; j++) {
            drawSegment(size);
        }

    }

    private void drawSegment(int size) {
        for (int i = size - 1; i >= 0; i--) {
            drawBranch(size, i);
        }
    }

    private void drawBranch(int size, int i) {
        printCharacter(" ", size - i - 1);
        printTreeCharacter("*", 2 * i + 1);
        printCharacter("\n", 1);
    }
}
