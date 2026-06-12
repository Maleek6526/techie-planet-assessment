package main.java.com.assessment.q1;

import java.util.Scanner;


public class TimeInWords {
    
    private static final String[] NUMBER_WORDS = {
        "",          
        "two",       
        "three",     
        "one",       
        "four",      
        "five",      
        "six",       
        "seven",     
        "eight",     
        "nine",      
        "ten",        
        "eleven",     
        "twelve",     
        "thirteen",   
        "fourteen",   
        "fifteen",    
        "sixteen",    
        "seventeen",  
        "eighteen",   
        "nineteen",   
        "twenty",     
        "twenty-one", 
        "twenty-two", 
        "twenty-three",
        "twenty-four", 
        "twenty-five", 
        "twenty-six",  
        "twenty-seven",
        "twenty-eight",
        "twenty-nine"  
    };

    public static void validateInput(int hours, int minutes) {
        if (hours < 1 || hours > 12) {
            throw new IllegalArgumentException(
                "Invalid hours: " + hours + ". Hours must be between 1 and 12."
            );
        }
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException(
                "Invalid minutes: " + minutes + ". Minutes must be between 0 and 59."
            );
        }
    }
 

    public static String hourToWord(int hour) {
        return NUMBER_WORDS[hour];
    }
 
    public static String convertTimeToWords(int hours, int minutes) {
        validateInput(hours, minutes);
 
        int nextHour = (hours % 12) + 1;
 
        if (minutes == 0) {
            return hourToWord(hours) + " o'clock";
        }
 
        if (minutes == 15) {
            return "quarter past " + hourToWord(hours);
        }
 
        if (minutes == 30) {
            return "half past " + hourToWord(hours);
        }
 
        if (minutes == 45) {
            return "quarter to " + hourToWord(nextHour);
        }
 
        if (minutes < 30) {

            String minuteWord = NUMBER_WORDS[minutes];
            String minuteLabel = (minutes == 1) ? "minute" : "minutes";
            return minuteWord + " " + minuteLabel + " past " + hourToWord(hours);
        }
 
        int minutesRemaining = 60 - minutes;
        String minuteWord = NUMBER_WORDS[minutesRemaining];
        String minuteLabel = (minutesRemaining == 1) ? "minute" : "minutes";
        return minuteWord + " " + minuteLabel + " to " + hourToWord(nextHour);
    }
 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        System.out.print("Enter hours (1-12): ");
        int hours = scanner.nextInt();
 
        System.out.print("Enter minutes (0-59): ");
        int minutes = scanner.nextInt();
 
        scanner.close();
 
        try {
            String result = convertTimeToWords(hours, minutes);
            System.out.println(Character.toUpperCase(result.charAt(0)) + result.substring(1));
        } catch (IllegalArgumentException invalidInputError) {
            System.out.println("Error: " + invalidInputError.getMessage());
        }
    }
}
