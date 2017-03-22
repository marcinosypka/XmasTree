package com.xmastree.draw;

import com.xmastree.draw.*;

import java.util.*;


public class XmasTreeDrawer {
    private Map<String, DrawXmasTreeStrategy> drawingStrategies;

    public XmasTreeDrawer() {
        drawingStrategies = new HashMap<>();
        drawingStrategies.put("LEWO", new DrawLeftXmasTree());
        drawingStrategies.put("PRAWO", new DrawRightXmasTree());
        drawingStrategies.put("GORA", new DrawUpXmasTree());
        drawingStrategies.put("DOL", new DrawDownXmasTree());
    }

    public void draw() {
        int size = getInt("Podaj wysokosc choinki (np.5, zakres liczb: 1-21): ", 1, 21);
        int segments = getInt("Podaj liczbe segmentow (np. 3, zakres liczb: 1-10): ", 1, 10);
        DrawXmasTreeStrategy drawXmasTreeStrategy = getStrategy();
        drawXmasTreeStrategy.drawXmasTree(size, segments);
    }

    private DrawXmasTreeStrategy getStrategy() {
        Scanner scanner = new Scanner(System.in);
        String option;
        DrawXmasTreeStrategy strategy;
        while (true) {
            try {
                System.out.println("Jaki typ choinki narysowac ?");
                showOptions();
                option = scanner.nextLine().toUpperCase();
                strategy = drawingStrategies.get(option);
                verifyOption(strategy);
                scanner.close();
                return strategy;
            } catch (NullPointerException npe) {
                System.out.println("Nie ma takiego typu choinki, sprobuj ponownie");
            } catch (NoSuchElementException nsee) {
                System.out.println("Wprowadzono znak EOT, koniec działania programu.");
                System.exit(1);
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
        }
    }

    private void verifyOption(DrawXmasTreeStrategy drawXmasTreeStrategy) {
        if (drawXmasTreeStrategy == null) {
            throw new NullPointerException();
        }
    }

    private void showOptions() {
        System.out.println("Opcje: ");
        for (String option : drawingStrategies.keySet()) {
            System.out.print(option + " ");
        }
        System.out.println();
    }

    private Integer getInt(String welcomeMessage, int lowerBound, int upperBound) {
        int result;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(welcomeMessage);
                result = Integer.parseInt(scanner.nextLine());
                checkSizeRange(result, lowerBound, upperBound);
                return result;
            } catch (InputMismatchException ime) {
                System.out.println(ime.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Podana wartość nie jest liczbą !");
            } catch (NoSuchElementException nsee) {
                System.out.println("Wprowadzono znak EOT, koniec działania programu.");
                System.exit(1);
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
        }
    }

    private void checkSizeRange(int result, int lowerBound, int upperBound) {
        if (result < lowerBound || result > upperBound) {
            throw new InputMismatchException("Podana wartość nie mieści się w zakresie od " + lowerBound + " do " + upperBound + ".");
        }
    }
}
