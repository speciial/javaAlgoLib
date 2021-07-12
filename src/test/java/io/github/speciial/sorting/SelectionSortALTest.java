package io.github.speciial.sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortALTest {

    @Test
    void testOneElement() {
        ArrayList<Double> numbers = new ArrayList<>(List.of(0.0));

        new SelectionSortAL(numbers);
    }

    @Test
    void testTwoEqualElements() {
        ArrayList<Double> numbers = new ArrayList<>(List.of(0.0, 0.0));
        new SelectionSortAL(numbers);

        for (int i = 0; i < numbers.size() - 1; i++) {
            assertTrue(numbers.get(i) <= numbers.get(i + 1));
        }
    }

    @Test
    void testThreeEqualElements() {
        ArrayList<Double> numbers = new ArrayList<>(List.of(0.0, 0.0, 0.0));
        new SelectionSortAL(numbers);

        for (int i = 0; i < numbers.size() - 1; i++) {
            assertTrue(numbers.get(i) <= numbers.get(i + 1));
        }
    }

    @Test
    void testTenRandomNumbers() {
        ArrayList<Double> numbers = new ArrayList<>(List.of(2.0, 4.0, 5.0, 6.0, 3.0, 1.0, 9.0, 0.0, 8.0, 7.0));
        new SelectionSortAL(numbers);

        for (int i = 0; i < numbers.size() - 1; i++) {
            assertTrue(numbers.get(i) <= numbers.get(i + 1));
        }
    }

    @Test
    void testTwentyRandomNumbers() {
        ArrayList<Double> numbers = new ArrayList<>(List.of(8.0, 9.0, 6.0, 14.0, 3.0, 0.0, 1.0, 12.0, 18.0, 4.0, 13.0, 15.0, 19.0, 5.0, 7.0, 17.0, 10.0, 16.0, 2.0, 11.0));
        new SelectionSortAL(numbers);

        for (int i = 0; i < numbers.size() - 1; i++) {
            assertTrue(numbers.get(i) <= numbers.get(i + 1));
        }
    }

}