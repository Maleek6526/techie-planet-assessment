package main.java.com.assessment.q2;

public class RemoveDuplicates {
 

    private static final int MAX_SUPPORTED_VALUE = 100_000;
 
    public static int[][] removeDuplicatesFromEachRow(int[][] grid) {
        if (grid == null) {
            return null;
        }
 
        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            grid[rowIndex] = removeDuplicatesFromOneRow(grid[rowIndex]);
        }
 
        return grid;
    }
 

    private static int[] removeDuplicatesFromOneRow(int[] row) {
        if (row == null) {
            return null;
        }
 
        boolean[] seenValues = new boolean[MAX_SUPPORTED_VALUE + 1];
 
        for (int position = 0; position < row.length; position++) {
            int currentValue = row[position];

            if (currentValue < 0 || currentValue > MAX_SUPPORTED_VALUE) {
                continue;
            }
 
            if (seenValues[currentValue]) {
                row[position] = 0;
            } else {
                seenValues[currentValue] = true;
            }
        }
 
        return row;
    }
 

    public static void printGrid(int[][] grid) {
        System.out.print("[");
        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            System.out.print("{");
            for (int position = 0; position < grid[rowIndex].length; position++) {
                System.out.print(grid[rowIndex][position]);
                if (position < grid[rowIndex].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("}");
            if (rowIndex < grid.length - 1) {
                System.out.print(",\n ");
            }
        }
        System.out.println("]");
    }
 

    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1, 2, 3, 4, 4, 3, 5},
            {1, 1, 1, 1, 1, 1, 1}
        };
 
        System.out.println("Before:");
        printGrid(grid);
 
        removeDuplicatesFromEachRow(grid);
 
        System.out.println("After:");
        printGrid(grid);
    }
}
