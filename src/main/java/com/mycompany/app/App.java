package com.mycompany.app;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Integer[] array1 = {1, 2, 3};
        //Integer[] array2 = {4, 5, 6};
        //String str1 = "Hello";
        //String str2 = "World";
//
        //int result = sum(str1, str2, array1, array2);
        //System.out.println("Result: " + result);
    }


    public static int sum(String str1, String str2, Integer[] array1, Integer[] array2) {
        int sumOfLengths = str1.length() + str2.length();

        int sumArray1 = 0;
        if (array1 != null) {
            for (int num : array1) {
                sumArray1 += num;
            }
        }

        int sumArray2 = 0;
        if (array2 != null) {
            for (int num : array2) {
                sumArray2 += num;
            }
        }

        int result = sumOfLengths + sumArray1 + sumArray2;

        return result;
    }
}
