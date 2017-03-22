package com.xmastree;

public class DrawRightXmasTree implements DrawXmasTreeStrategy {

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
        CharacterPrinter.printCharacter("\n", 1);
    }

    private void drawBranch(int size, int i) {
        CharacterPrinter.printTreeCharacter("*", i);
        CharacterPrinter.printCharacter(" ", size - i);

    }
}
