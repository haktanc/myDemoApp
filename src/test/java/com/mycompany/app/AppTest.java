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
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3);
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(4, 5, 6);
        int result1 = App.sum("Hello", "World", array1, array2);
        assertEquals(31, result1);
    }

    public void testSum2() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3);
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(4, 5, 6);
        // test case 2: One array contains negative numbers
        Integer[] array3 = {-1, -2, -3};
        ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(-1, -2, -3);
        int result2 = App.sum("Good", "Morning", array3, array2);
        assertEquals(20, result2);
    }

    public void testSum3() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3);
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(4, 5, 6);
        // test case 3: One array is null
        int result3 = App.sum("Hi", "There", array1, null);
        assertEquals(13, result3);
    }

    public void testSum4() {
        // test case 4: Both arrays are empty
        ArrayList<Integer> array5 = new ArrayList<>();
        ArrayList<Integer> array6 = new ArrayList<>();
        
        
        int result4 = App.sum("", "", array5, array6);
        assertEquals(0, result4);
    }

    public void testSum5(){
        // test case 5: One string is empty, one array is null
        ArrayList<Integer> array7 = new ArrayList<>(Arrays.asList(1, 2);
        int result5 = App.sum("", "Test", array7, null);
        assertEquals(7, result5);
    }
}
