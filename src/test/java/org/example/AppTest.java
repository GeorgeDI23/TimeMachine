package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @BeforeEach
    public void setUp(){
        testArray1 = new String[]{"1", "5", "9", "4"};
        testArray2 = new String[]{"1", "5", "15", "9", "4"};

    }

    App sort = new App();
    String[] testArray1;
    String[] testArray2;

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void sort_single_digit_numbers(){
        // Given
        String[] expected = new String[]{"1", "4", "5", "9"};
        // When
        sort.sortStringNumbers(testArray1);
        // Then
        assertArrayEquals(expected, testArray1);
    }

    @Test
    // no edge cases
    public void sort_a_normal_list(){
        // Given
        String[] expected = new String[]{"1", "4", "5", "9", "15"};
        // When
        sort.sortStringNumbers(testArray2);
        // Then
        assertArrayEquals(expected,testArray2);
    }

    @Test
    // no edge cases
    public void sort_a_list_with_larger_nums(){
        // Given
        String[] testArray = {"1", "9", "35", "5", "25", "4", "15"};
        String[] expected = new String[]{"1", "4", "5", "9", "15", "25", "35"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    // no edge cases
    public void sort_a_list_with_leading_zeros(){
        // Given
        String[] testArray = {"1", "09", "35", "5", "025", "4", "15"};
        String[] expected = new String[]{"1", "4", "5", "09", "15", "025", "35"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    public void sort_a_list_with_more_zeros(){
        // Given
        String[] testArray = {"1", "09", "000", "35", "5", "025", "4", "15"};
        String[] expected = new String[]{"000", "1", "4", "5", "09", "15", "025", "35"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    public void sort_a_list_with_negatives(){
        // Given
        String[] testArray = {"1", "-9", "35", "5", "-25", "4", "15"};
        String[] expected = new String[]{ "-25", "-9", "1", "4", "5", "15", "35"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    public void sort_a_list_with_negatives_and_leading_zeros(){
        // Given
        String[] testArray = {"1", "-009", "35", "5", "-25", "0004", "015"};
        String[] expected = new String[]{ "-25", "-009", "1", "0004", "5", "015", "35"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    public void sort_a_list_with_decimals(){
        // Given
        String[] testArray = {"1", "9", "35", "5.24" ,"5.1444", "25", "4", "15"};
        String[] expected = new String[]{"1", "4", "5.1444", "5.24", "9", "15", "25", "35"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    public void sort_a_list_with_ALL_the_things(){
        // Given
        String[] testArray = {"005", "-7", "9", "-0008", "3.14", "-8.78", "002.5", "-0004.20"};
        String[] expected = new String[]{"-8.78", "-0008", "-7", "-0004.20", "002.5", "3.14", "005", "9"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    //submethod tests
    @Test
    public void testCustomComparator(){
        //given
        String numOne = "15";
        String numTwo = "9";
        //when
        Boolean actual = sort.customComparator(numOne, numTwo);
        //then
        assertFalse(actual);
    }

    @Test
    public void testCustomComparatorSameDigits(){
        //given
        String numOne = "15";
        String numTwo = "25";
        //when
        Boolean actual = sort.customComparator(numOne, numTwo);
        //then
        assertTrue(actual);
    }

    @Test
    public void testCustomComparatorLeadingZeros(){
        //given
        String numOne = "015";
        String numTwo = "25";
        //when
        Boolean actual = sort.customComparator(numOne, numTwo);
        //then
        assertTrue(actual);
    }

    @Test
    public void testCustomComparatorLeadingZeros2(){
        //given
        String numOne = "25";
        String numTwo = "015";
        //when
        Boolean actual = sort.customComparator(numOne, numTwo);
        //then
        assertFalse(actual);
    }
    @Test
    public void testCustomComparatorLeadingZeros3(){
        //given
        String numOne = "09";
        String numTwo = "1";
        //when
        Boolean actual = sort.customComparator(numOne, numTwo);
        //then
        assertFalse(actual);
    }

    @Test
    public void testCustomComparatorNegatives(){
        //given
        String numOne = "-2";
        String numTwo = "1";
        //when
        Boolean actual = sort.customComparator(numOne, numTwo);
        //then
        assertTrue(actual);
    }

    @Test
    public void testCustomComparatorNegatives2(){
        //given
        String numOne = "1";
        String numTwo = "-2";
        //when
        Boolean actual = sort.customComparator(numOne, numTwo);
        //then
        assertFalse(actual);
    }

    @Test
    public void testCustomComparatorTwoNegatives(){
        //given
        String numOne = "-1";
        String numTwo = "-2";
        //when
        Boolean actual = sort.customComparator(numOne, numTwo);
        //then
        assertFalse(actual);
    }

    @Test
    public void testCustomComparatorTwoNegatives2(){
        //given
        String numOne = "-2";
        String numTwo = "-1";
        //when
        Boolean actual = sort.customComparator(numOne, numTwo);
        //then
        assertTrue(actual);
    }

    @Test
    public void testRemoveLeadingZeros(){
        //given
        String num = "00000015";
        String expected = "15";
        //when
        String actual = sort.removeLeadingZeros(num);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveLeadingZerosWithAllZeros(){
        //given
        String num = "00000";
        String expected = "0";
        //when
        String actual = sort.removeLeadingZeros(num);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveDecimal(){
        //given
        String decimalNum = "3.14";
        String expected = "3";
        //when
        String actual = sort.removeDecimal(decimalNum);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveDecimalNoDecimal(){
        //given
        String decimalNum = "3";
        String expected = "3";
        //when
        String actual = sort.removeDecimal(decimalNum);
        //then
        Assert.assertEquals(expected, actual);
    }
}
