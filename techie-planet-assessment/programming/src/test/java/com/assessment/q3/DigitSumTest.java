package test.java.com.assessment.q3;
import main.java.com.assessment.q3.DigitSum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
 
class DigitSumTest {
 
    @Test
    @DisplayName("Q3a sample: long number string sums to 161")
    void longNumberStringSumsTo161() {
        String input = "1234445123444512344451234445123444512344451234445";
        assertEquals(161, DigitSum.sumOfDigits(input));
    }
 
    @Test
    @DisplayName("Q3a sample: 1234445 sums to 23")
    void shortNumberStringSumsTo23() {
        assertEquals(23, DigitSum.sumOfDigits("1234445"));
    }

    @Test
    @DisplayName("Single digit 0 returns 0")
    void singleDigitZero() {
        assertEquals(0, DigitSum.sumOfDigits("0"));
    }
 
    @Test
    @DisplayName("Single digit 9 returns 9")
    void singleDigitNine() {
        assertEquals(9, DigitSum.sumOfDigits("9"));
    }
 
    @Test
    @DisplayName("Single digit 5 returns 5")
    void singleDigitFive() {
        assertEquals(5, DigitSum.sumOfDigits("5"));
    }
 
    @Test
    @DisplayName("All ones: 1111 sums to 4")
    void allOnesSumToFour() {
        assertEquals(4, DigitSum.sumOfDigits("1111"));
    }
 
    @Test
    @DisplayName("All nines: 999 sums to 27")
    void allNinesSumTo27() {
        assertEquals(27, DigitSum.sumOfDigits("999"));
    }
 
    @Test
    @DisplayName("Q3b sample: 1234445 has digital root 5")
    void digitalRootOf1234445is5() {
        assertEquals(5, DigitSum.digitalRoot("1234445"));
    }
 
    @Test
    @DisplayName("Q3b: digital root of single digit is itself")
    void digitalRootOfSingleDigitIsItself() {
        assertEquals(7, DigitSum.digitalRoot("7"));
    }
 
    @Test
    @DisplayName("Q3b: 999 -> 27 -> 9, digital root is 9")
    void digitalRootOf999is9() {
        assertEquals(9, DigitSum.digitalRoot("999"));
    }
 
    @Test
    @DisplayName("Q3b: 199 -> 19 -> 10 -> 1, digital root is 1")
    void digitalRootOf199is1() {
        assertEquals(1, DigitSum.digitalRoot("199"));
    }
 
    @Test
    @DisplayName("Q3b: long number string digital root is a single digit")
    void digitalRootOfLongStringIsSingleDigit() {
        String input = "1234445123444512344451234445123444512344451234445";
        int result = DigitSum.digitalRoot(input);
        assertTrue(result >= 0 && result <= 9,
            "Digital root must be a single digit but was: " + result);
    }
 
    @Test
    @DisplayName("Empty string throws IllegalArgumentException")
    void emptyStringThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> DigitSum.sumOfDigits(""));
    }
 
    @Test
    @DisplayName("Null input throws IllegalArgumentException")
    void nullInputThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> DigitSum.sumOfDigits(null));
    }
 
    @Test
    @DisplayName("String with letters throws IllegalArgumentException")
    void stringWithLettersThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> DigitSum.sumOfDigits("123abc"));
    }
 
    @Test
    @DisplayName("String with spaces throws IllegalArgumentException")
    void stringWithSpacesThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> DigitSum.sumOfDigits("1 2 3"));
    }
}