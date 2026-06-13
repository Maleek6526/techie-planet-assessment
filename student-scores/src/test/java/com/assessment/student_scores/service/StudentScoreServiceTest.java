package com.assessment.student_scores.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class StudentScoreServiceTest {

    private final StudentScoreService service = new StudentScoreService(null, null);


    @Test
    @DisplayName("Mean of [85, 70, 90, 60, 75] is 76.0")
    void meanOfFiveScores() {
        List<Integer> scores = Arrays.asList(85, 70, 90, 60, 75);
        assertEquals(76.0, service.calculateMean(scores), 0.001);
    }

    @Test
    @DisplayName("Mean of a single value is that value")
    void meanOfSingleValue() {
        List<Integer> scores = Collections.singletonList(50);
        assertEquals(50.0, service.calculateMean(scores), 0.001);
    }

    @Test
    @DisplayName("Mean of an empty list is 0")
    void meanOfEmptyListIsZero() {
        assertEquals(0.0, service.calculateMean(Collections.emptyList()), 0.001);
    }


    @Test
    @DisplayName("Median of [85, 70, 90, 60, 75] (sorted: 60,70,75,85,90) is 75")
    void medianOfFiveScoresIsMiddleValue() {
        List<Integer> scores = Arrays.asList(85, 70, 90, 60, 75);
        assertEquals(75.0, service.calculateMedian(scores), 0.001);
    }

    @Test
    @DisplayName("Median of a single value is that value")
    void medianOfSingleValue() {
        List<Integer> scores = Collections.singletonList(42);
        assertEquals(42.0, service.calculateMedian(scores), 0.001);
    }


    @Test
    @DisplayName("Median of [10, 20, 30, 40] is average of 20 and 30 = 25")
    void medianOfFourScoresIsAverageOfMiddleTwo() {
        List<Integer> scores = Arrays.asList(10, 20, 30, 40);
        assertEquals(25.0, service.calculateMedian(scores), 0.001);
    }

    @Test
    @DisplayName("Median of an empty list is 0")
    void medianOfEmptyListIsZero() {
        assertEquals(0.0, service.calculateMedian(Collections.emptyList()), 0.001);
    }


    @Test
    @DisplayName("Mode of [70, 70, 85, 90, 60] is [70] - appears twice")
    void modeWithOneRepeatedValue() {
        List<Integer> scores = Arrays.asList(70, 70, 85, 90, 60);
        assertEquals(Collections.singletonList(70), service.calculateMode(scores));
    }


    @Test
    @DisplayName("Mode of [60, 60, 70, 70, 80] is [60, 70] - both appear twice")
    void modeWithTwoTiedValues() {
        List<Integer> scores = Arrays.asList(60, 60, 70, 70, 80);
        assertEquals(Arrays.asList(60, 70), service.calculateMode(scores));
    }


    @Test
    @DisplayName("Mode of [85, 70, 90, 60, 75] with no repeats returns all values")
    void modeWithNoRepeatsReturnsAllValues() {
        List<Integer> scores = Arrays.asList(85, 70, 90, 60, 75);
        List<Integer> result = service.calculateMode(scores);

        assertEquals(Arrays.asList(60, 70, 75, 85, 90), result);
    }

    @Test
    @DisplayName("Mode of an empty list is an empty list")
    void modeOfEmptyListIsEmpty() {
        assertTrue(service.calculateMode(Collections.emptyList()).isEmpty());
    }

    @Test
    @DisplayName("Mode of a single value is that value")
    void modeOfSingleValue() {
        List<Integer> scores = Collections.singletonList(99);
        assertEquals(Collections.singletonList(99), service.calculateMode(scores));
    }

    @Test
    @DisplayName("Mode of all identical values returns that one value")
    void modeOfAllIdenticalValues() {
        List<Integer> scores = Arrays.asList(80, 80, 80, 80);
        assertEquals(Collections.singletonList(80), service.calculateMode(scores));
    }
}