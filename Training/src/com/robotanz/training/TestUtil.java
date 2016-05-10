package com.robotanz.training;

import java.util.stream.IntStream;

import com.robotanz.training.sorters.ISorter;

public class TestUtil {

    public static void testSorter(ISorter sorter, int arraySize) {

        int[] array = ArrayUtil.randomIntArray(arraySize);

        int[] proofArray = IntStream.of(array).sorted().toArray();

        sorter.sort(array);
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