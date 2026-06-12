package main.java.com.assessment.q3;

import java.util.Scanner;
 
public class DigitSum {
 

    public static int sumOfDigits(String numberAsString) {
        if (numberAsString == null || numberAsString.isEmpty()) {
            throw new IllegalArgumentException("Input must not be null or empty.");
        }
 
        for (char character : numberAsString.toCharArray()) {
            if (character < '0' || character > '9') {
                throw new IllegalArgumentException(
                    "Input must contain only digit characters. Found: " + character
                );
            }
        }
 
        return recursiveSumOfDigits(numberAsString);
    }
 
    private static int recursiveSumOfDigits(String remainingDigits) {
        if (remainingDigits.length() == 1) {
            return remainingDigits.charAt(0) - '0';
        }
 
        int firstDigitValue = remainingDigits.charAt(0) - '0';
        String remainingAfterFirst = remainingDigits.substring(1);
 
        return firstDigitValue + recursiveSumOfDigits(remainingAfterFirst);
    }
 

    public static int digitalRoot(String numberAsString) {
        int currentSum = sumOfDigits(numberAsString);
 
        while (currentSum >= 10) {
            currentSum = sumOfDigits(String.valueOf(currentSum));
        }
 
        return currentSum;
    }
 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        System.out.print("Enter a number string: ");
        String input = scanner.nextLine().trim();
 
        scanner.close();
 
        try {
            int digitSum = sumOfDigits(input);
            System.out.println("Sum of digits : " + digitSum);
 
            int root = digitalRoot(input);
            System.out.println("Digital root  : " + root);
        } catch (IllegalArgumentException invalidInputError) {
            System.out.println("Error: " + invalidInputError.getMessage());
        }
    }
}