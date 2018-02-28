package com.robotanz.training;

import java.util.stream.IntStream;

import com.robotanz.training.sorters.ISorter;

public class TestUtil {

	/**
	 * Sort a random int array of specified size
	 * @param sorter
	 * @param arraySize
	 */
    public static void testSorter(ISorter sorter, int arraySize) {

        int[] array = ArrayUtil.randomIntArray(arraySize);

        int[] proofArray = IntStream.of(array).sorted().toArray();

        testSorter(sorter, array);

        System.out.println(ArrayUtil.arrayToString(array, 64));

        boolean success = true;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != proofArray[i]) {
                success = false;
                break;
            }
        }

        String sorterName = sorter.getClass().getSimpleName();
        System.out.println(sorterName + (success ? " OK" : " Failed!"));
    }
    
    public static void testSorter(ISorter sorter, int[] array) {
    	
        long startTime = System.currentTimeMillis();
        sorter.sort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Sorted " + array.length + " elements in " + (endTime - startTime) + " ms");
    }
    
    /**
     * Sort a random, then a sorted array of same size
     * @param sorter
     * @param arraySize
     */
    public static void doubleTestSorter(ISorter sorter, int arraySize) {
    	
        int[] array = ArrayUtil.randomIntArray(arraySize);

        int[] proofArray = IntStream.of(array).sorted().toArray();

        testSorter(sorter, array);
        testSorter(sorter, array);

        System.out.println(ArrayUtil.arrayToString(array, 64));

        boolean success = true;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != proofArray[i]) {
                success = false;
                break;
            }
        }

        String sorterName = sorter.getClass().getSimpleName();
        System.out.println(sorterName + (success ? " OK" : " Failed!"));

    }
}
