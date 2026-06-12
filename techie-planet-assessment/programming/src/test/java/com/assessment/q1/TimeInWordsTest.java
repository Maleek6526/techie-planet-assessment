package test.java.com.assessment.q1;
import org.junit.jupiter.api.Test;

import main.java.com.assessment.q1.TimeInWords;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;


class TimeInWordsTest {
    @Test
    @DisplayName("5:00 -> five o'clock")    
    void fiveOClock() {
        assertEquals("five o'clock", TimeInWords.convertTimeToWords(5, 0));
    }
 
    @Test
    @DisplayName("5:01 -> one minute past five")
    void oneMinutePastFive() {
        assertEquals("one minute past five", TimeInWords.convertTimeToWords(5, 1));
    }
 
    @Test
    @DisplayName("5:10 -> ten minutes past five")
    void tenMinutesPastFive() {
        assertEquals("ten minutes past five", TimeInWords.convertTimeToWords(5, 10));
    }
 
    @Test
    @DisplayName("5:30 -> half past five")
    void halfPastFive() {
        assertEquals("half past five", TimeInWords.convertTimeToWords(5, 30));
    }
 
    @Test
    @DisplayName("5:40 -> twenty minutes to six")
    void twentyMinutesToSix() {
        assertEquals("twenty minutes to six", TimeInWords.convertTimeToWords(5, 40));
    }
 
    @Test
    @DisplayName("5:45 -> quarter to six")
    void quarterToSix() {
        assertEquals("quarter to six", TimeInWords.convertTimeToWords(5, 45));
    }
 
    @Test
    @DisplayName("5:47 -> thirteen minutes to six (sample output from question)")
    void thirteenMinutesToSix() {
        assertEquals("thirteen minutes to six", TimeInWords.convertTimeToWords(5, 47));
    }
 
    @Test
    @DisplayName("5:28 -> twenty-eight minutes past five")
    void twentyEightMinutesPastFive() {
        assertEquals("twenty-eight minutes past five", TimeInWords.convertTimeToWords(5, 28));
    }

    @Test
    @DisplayName("5:15 -> quarter past five")
    void quarterPastFive() {
        assertEquals("quarter past five", TimeInWords.convertTimeToWords(5, 15));
    }

    @Test
    @DisplayName("1 minute past uses singular 'minute'")
    void oneMinuteSingular() {
        String result = TimeInWords.convertTimeToWords(3, 1);
        assertTrue(result.contains("one minute past"), "Expected 'one minute past' but got: " + result);
    }
 
    @Test
    @DisplayName("59 minutes = one minute to next hour, uses singular 'minute'")
    void fiftyNineMinutesIsSingularMinuteTo() {
        assertEquals("one minute to two", TimeInWords.convertTimeToWords(1, 59));
    }
 
 
    @Test
    @DisplayName("12:45 -> quarter to one (12 wraps to 1)")
    void twelveFortyFiveIsQuarterToOne() {
        assertEquals("quarter to one", TimeInWords.convertTimeToWords(12, 45));
    }
 
    @Test
    @DisplayName("12:31 -> twenty-nine minutes to one")
    void twelveThirtyOneIsTwentyNineMinutesToOne() {
        assertEquals("twenty-nine minutes to one", TimeInWords.convertTimeToWords(12, 31));
    }
 
    @Test
    @DisplayName("Edge: hour=1, minute=0 -> one o'clock")
    void minimumHourZeroMinutes() {
        assertEquals("one o'clock", TimeInWords.convertTimeToWords(1, 0));
    }
 
    @Test
    @DisplayName("Edge: hour=12, minute=0 -> twelve o'clock")
    void maximumHourZeroMinutes() {
        assertEquals("twelve o'clock", TimeInWords.convertTimeToWords(12, 0));
    }
 
    @Test
    @DisplayName("Edge: minute=59 -> one minute to next hour")
    void fiftyNineMinutes() {
        assertEquals("one minute to three", TimeInWords.convertTimeToWords(2, 59));
    }
 
    @Test
    @DisplayName("Edge: minute=29 -> twenty-nine minutes past")
    void twentyNineMinutes() {
        assertEquals("twenty-nine minutes past four", TimeInWords.convertTimeToWords(4, 29));
    }
 
    @Test
    @DisplayName("Edge: minute=31 -> twenty-nine minutes to next hour")
    void thirtyOneMinutes() {
        assertEquals("twenty-nine minutes to five", TimeInWords.convertTimeToWords(4, 31));
    }
 
    @Test
    @DisplayName("Invalid: hour=0 throws IllegalArgumentException")
    void hourZeroIsInvalid() {
        assertThrows(IllegalArgumentException.class,
            () -> TimeInWords.convertTimeToWords(0, 0));
    }
 
    @Test
    @DisplayName("Invalid: hour=13 throws IllegalArgumentException")
    void hourThirteenIsInvalid() {
        assertThrows(IllegalArgumentException.class,
            () -> TimeInWords.convertTimeToWords(13, 30));
    }
 
    @Test
    @DisplayName("Invalid: minute=60 throws IllegalArgumentException")
    void minuteSixtyIsInvalid() {
        assertThrows(IllegalArgumentException.class,
            () -> TimeInWords.convertTimeToWords(5, 60));
    }
 
    @Test
    @DisplayName("Invalid: minute=-1 throws IllegalArgumentException")
    void negativeMinuteIsInvalid() {
        assertThrows(IllegalArgumentException.class,
            () -> TimeInWords.convertTimeToWords(5, -1));
    }
 
    @Test
    @DisplayName("Invalid: hour=-1 throws IllegalArgumentException")
    void negativeHourIsInvalid() {
        assertThrows(IllegalArgumentException.class,
            () -> TimeInWords.convertTimeToWords(-1, 0));
    }
}