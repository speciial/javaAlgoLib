package io.github.speciial;

import io.github.speciial.sorting.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MainApp {

    private final Scanner consoleScanner;

    private final String[] options = new String[]{
            "Sorting",
            "Trees",
            "Graphs",
            "Misc",
            "Quit"
    };

    private enum SortingAlgorithm {
        INSERTION_SORT,
        SELECTION_SORT,
        HEAP_SORT,
        MERGE_SORT,
        QUICK_SORT
    }

    public MainApp() {
        consoleScanner = new Scanner(System.in);

        System.out.println("--------------------------");
        System.out.println("|                        |");
        System.out.println("| JAVA ALGORITHM LIBRARY |");
        System.out.println("|                        |");
        System.out.println("--------------------------");

        boolean running = true;
        while (running) {
            for (int i = 0; i < options.length; i++) {
                System.out.println("[" + i + "]" + " " + options[i]);
            }
            int choice = readInt("Pick one");

            String pickedOption;
            try {
                pickedOption = options[choice];
            } catch (ArrayIndexOutOfBoundsException e) {
                pickedOption = "default";
            }

            switch (pickedOption) {
                case "Sorting" -> {
                    System.out.println("Sorting");

                    // There are a lot of things wrong with this. We probably need to run this
                    // multiple times with different arrays / ArrayLists to get a more accurate
                    // estimate of how much faster simple arrays are.
                    // We should also include different sizes and compare all algorithms. But I
                    // don't know how I would want to structure that right now, so we are doing
                    // the stupidest thing I can think of.
                    //
                    // [ ] run the timing on multiple different arrays
                    // [ ] include different sizes
                    // [x] include all algorithms

                    int arrayCount = 10000;
                    RandomNumberList numbersList = createRandomNumberList(arrayCount);

                    for (SortingAlgorithm algorithm : SortingAlgorithm.values()) {
                        System.out.println(algorithm.name() + ": ");
                        RandomNumberList list = copyRandomNumberList(numbersList);

                        long time = timeSortingAlgorithm(algorithm, list.numbers);
                        System.out.println("\tSimple Array: " + time / 1000000 + "ms");

                        long timeAL = timeSortingAlgorithm(algorithm, list.numbersAL);
                        System.out.println("\tArrayList   : " + timeAL / 1000000 + "ms");
                    }

                }
                case "Trees" -> System.out.println("Trees");
                case "Graphs" -> System.out.println("Graphs");
                case "Misc" -> System.out.println("Misc");
                case "Quit" -> {
                    System.out.println("Quitting Application");
                    running = false;
                }
                default -> System.out.println("Default");
            }
        }
    }

    private int readInt(String text) {
        System.out.print(text + " > ");
        return consoleScanner.nextInt();
    }

    private String readLine(String text) {
        System.out.print(text + " > ");
        return consoleScanner.nextLine();
    }

    private long timeSortingAlgorithm(SortingAlgorithm algorithm, double[] numbers) {
        long start = 0;
        long end = 0;
        switch (algorithm) {
            case INSERTION_SORT -> {
                start = System.nanoTime();
                new InsertionSort(numbers);
                end = System.nanoTime();
            }
            case SELECTION_SORT -> {
                start = System.nanoTime();
                new SelectionSort(numbers);
                end = System.nanoTime();
            }
            case HEAP_SORT -> {
                start = System.nanoTime();
                new HeapSort(numbers);
                end = System.nanoTime();
            }
            case MERGE_SORT -> {
                start = System.nanoTime();
                new MergeSort(numbers);
                end = System.nanoTime();
            }
            case QUICK_SORT -> {
                start = System.nanoTime();
                new QuickSort(numbers);
                end = System.nanoTime();
            }
        }
        return (end - start);
    }

    private long timeSortingAlgorithm(SortingAlgorithm algorithm, ArrayList<Double> numbers) {
        long start = 0;
        long end = 0;
        switch (algorithm) {
            case INSERTION_SORT -> {
                start = System.nanoTime();
                new InsertionSortAL(numbers);
                end = System.nanoTime();
            }
            case SELECTION_SORT -> {
                start = System.nanoTime();
                new SelectionSortAL(numbers);
                end = System.nanoTime();
            }
            case HEAP_SORT -> {
                start = System.nanoTime();
                new HeapSortAL(numbers);
                end = System.nanoTime();
            }
            case MERGE_SORT -> {
                start = System.nanoTime();
                new MergeSortAL(numbers);
                end = System.nanoTime();
            }
            case QUICK_SORT -> {
                start = System.nanoTime();
                new QuickSortAL(numbers);
                end = System.nanoTime();
            }
        }
        return (end - start);
    }

    private RandomNumberList createRandomNumberList(int arrayCount) {
        RandomNumberList result = new RandomNumberList();
        result.numbers = new double[arrayCount];
        result.numbersAL = new ArrayList<>(arrayCount);
        for (int i = 0; i < arrayCount; i++) {
            double n = ThreadLocalRandom.current().nextDouble() * 100;
            result.numbers[i] = n;
            result.numbersAL.add(n);
        }
        return result;
    }

    private RandomNumberList copyRandomNumberList(RandomNumberList list) {
        RandomNumberList result = new RandomNumberList();
        result.numbers = new double[list.numbers.length];
        result.numbersAL = new ArrayList<>(list.numbers.length);
        for (int i = 0; i < list.numbers.length; i++) {
            result.numbers[i] = list.numbers[i];
            result.numbersAL.add(list.numbers[i]);
        }
        return result;
    }

    private static class RandomNumberList {
        double[] numbers;
        ArrayList<Double> numbersAL;
    }

    public static void main(String[] args) {
        new MainApp();
    }

}
