package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;
/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{


    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testSum1() {
        // test case 1: Both arrays contain positive numbers
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {4, 5, 6};
        int result1 = App.sum("Hello", "World", array1, array2);
        assertEquals(31, result1);
    }

    public void testSum2() {
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {4, 5, 6};
        // test case 2: One array contains negative numbers
        Integer[] array3 = {-1, -2, -3};
        int result2 = App.sum("Good", "Morning", array3, array2);
        assertEquals(20, result2);
    }

    public void testSum3() {
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {4, 5, 6};
        // test case 3: One array is null
        Integer[] array4 = null;
        int result3 = App.sum("Hi", "There", array1, array4);
        assertEquals(13, result3);
    }

    public void testSum4() {
        // test case 4: Both arrays are empty
        Integer[] array5 = {};
        Integer[] array6 = {};
        int result4 = App.sum("", "", array5, array6);
        assertEquals(0, result4);
    }

    public void testSum5(){
        // test case 5: One string is empty, one array is null
        Integer[] array7 = {1, 2};
        int result5 = App.sum("", "Test", array7, null);
        assertEquals(7, result5);
    }
}
