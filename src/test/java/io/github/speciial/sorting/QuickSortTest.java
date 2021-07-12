package io.github.speciial.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testOneElement() {
        double[] numbers = new double[]{0};
        new QuickSort(numbers);
    }

    @Test
    void testTwoEqualElements() {
        double[] numbers = new double[]{0, 0};
        new QuickSort(numbers);

        for (int i = 0; i < numbers.length - 1; i++) {
            assertTrue(numbers[i] <= numbers[i + 1]);
        }
    }

    @Test
    void testThreeEqualElements() {
        double[] numbers = new double[]{0, 0, 0};
        new QuickSort(numbers);

        for (int i = 0; i < numbers.length - 1; i++) {
            assertTrue(numbers[i] <= numbers[i + 1]);
        }
    }

    @Test
    void testTenRandomNumbers() {
        double[] numbers = new double[]{7, 2, 0, 8, 4, 5, 1, 9, 6, 3};
        new QuickSort(numbers);

        for (int i = 0; i < numbers.length - 1; i++) {
            assertTrue(numbers[i] <= numbers[i + 1]);
        }
    }

    @Test
    void testTwentyRandomNumbers() {
        double[] numbers = new double[]{7, 10, 16, 17, 5, 11, 6, 8, 13, 3, 12, 20, 4, 19, 18, 0, 14, 1, 9, 2};
        new QuickSort(numbers);

        for (int i = 0; i < numbers.length - 1; i++) {
            assertTrue(numbers[i] <= numbers[i + 1]);
        }
    }

}