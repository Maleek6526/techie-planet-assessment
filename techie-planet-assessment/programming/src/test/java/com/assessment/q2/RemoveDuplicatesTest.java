package test.java.com.assessment.q2;

import main.java.com.assessment.q2.RemoveDuplicates;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
 
class RemoveDuplicatesTest {
 
    @Test
    @DisplayName("Sample from question: two rows with multiple duplicates")
    void sampleFromQuestionBrief() {
        int[][] grid = {
            {1, 3, 1, 2, 3, 4, 4, 3, 5},
            {1, 1, 1, 1, 1, 1, 1}
        };
 
        int[][] result = RemoveDuplicates.removeDuplicatesFromEachRow(grid);
 
        assertArrayEquals(new int[]{1, 3, 0, 2, 0, 4, 0, 0, 5}, result[0]);
        assertArrayEquals(new int[]{1, 0, 0, 0, 0, 0, 0}, result[1]);
    }
 
 
    @Test
    @DisplayName("Row with no duplicates stays unchanged")
    void rowWithNoDuplicatesIsUnchanged() {
        int[][] grid = {
            {1, 2, 3, 4, 5}
        };
 
        int[][] result = RemoveDuplicates.removeDuplicatesFromEachRow(grid);
 
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result[0]);
    }
 
 
    @Test
    @DisplayName("Row where all values are the same — only first stays")
    void rowWhereAllValuesAreTheSame() {
        int[][] grid = {
            {7, 7, 7, 7}
        };
 
        int[][] result = RemoveDuplicates.removeDuplicatesFromEachRow(grid);
 
        assertArrayEquals(new int[]{7, 0, 0, 0}, result[0]);
    }
 
 
    @Test
    @DisplayName("Row with several different values each appearing multiple times")
    void rowWithManyDifferentDuplicates() {
        int[][] grid = {
            {2, 5, 2, 8, 5, 8, 9}
        };
 
        int[][] result = RemoveDuplicates.removeDuplicatesFromEachRow(grid);
 
        assertArrayEquals(new int[]{2, 5, 0, 8, 0, 0, 9}, result[0]);
    }

 
    @Test
    @DisplayName("Row with a single element stays unchanged")
    void singleElementRow() {
        int[][] grid = {
            {42}
        };
 
        int[][] result = RemoveDuplicates.removeDuplicatesFromEachRow(grid);
 
        assertArrayEquals(new int[]{42}, result[0]);
    }
 
    @Test
    @DisplayName("Grid where rows have different lengths — each processed independently")
    void rowsOfDifferentLengths() {
        int[][] grid = {
            {1, 2, 1},
            {3, 3, 3, 3},
            {4, 5, 6}
        };
 
        int[][] result = RemoveDuplicates.removeDuplicatesFromEachRow(grid);
 
        assertArrayEquals(new int[]{1, 2, 0},       result[0]);
        assertArrayEquals(new int[]{3, 0, 0, 0},    result[1]);
        assertArrayEquals(new int[]{4, 5, 6},        result[2]);
    }
 
    @Test
    @DisplayName("Empty grid returns empty grid without error")
    void emptyGrid() {
        int[][] grid = {};
        int[][] result = RemoveDuplicates.removeDuplicatesFromEachRow(grid);
        assertEquals(0, result.length);
    }
 
    @Test
    @DisplayName("Null grid returns null without throwing exception")
    void nullGridReturnsNull() {
        int[][] result = RemoveDuplicates.removeDuplicatesFromEachRow(null);
        assertNull(result);
    }
 
    @Test
    @DisplayName("Zero is treated as a normal value — duplicates of 0 become 0")
    void zeroIsAValidValueAndDuplicatesAreReplaced() {
        int[][] grid = {
            {0, 1, 0, 2, 0}
        };
 
        int[][] result = RemoveDuplicates.removeDuplicatesFromEachRow(grid);
 
        assertArrayEquals(new int[]{0, 1, 0, 2, 0}, result[0]);
    }
 
 
    @Test
    @DisplayName("Large row with 1000 elements processes without error")
    void largeRowProcessesWithoutError() {
        int[] largeRow = new int[1000];
        for (int i = 0; i < 1000; i++) {
            largeRow[i] = i % 10;
        }
 
        int[][] grid = {largeRow};
        int[][] result = RemoveDuplicates.removeDuplicatesFromEachRow(grid);
 
        for (int i = 0; i < 10; i++) {
            assertEquals(i, result[0][i], "First occurrence of " + i + " should stay");
        }
        for (int i = 10; i < 1000; i++) {
            assertEquals(0, result[0][i], "Duplicate at position " + i + " should be 0");
        }
    }
}
 
