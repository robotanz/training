package com.robotanz.training.sorters;

import com.robotanz.training.ArrayUtil;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * InsertionSort: simple insertion sort with average complexity of O(n²). This is similar to the
 * {@link SelectionSort}, however it may perform better in most cases.
 * <p>
 * Created on 10 mai 2016
 *
 * @author Jgenti
 */
public class InsertionSort {

    /**
     * Sort the given array
     *
     * @param array
     */
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * Sort a range of values inside the specified array
     *
     * @param array
     * @param first first element index
     * @param last last element index
     */
    public static void sort(int[] array, int first, int last) {

        if (first == last) {
            // single value? return
            return;
        }
        else if (last - first == 1) {
            // if there are only two values
            if (array[first] > array[last]) {
                ArrayUtil.swap(array, first, last);
            }
            return;
        }
        else {

            // Actual Insertion Sort

            // iterate on the values to be inserted
            for (int i = first + 1; i <= last; ++i) {

                // move the value upstream until it is inserted in the right place
                for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; --j) {
                    ArrayUtil.swap(array, j + 1, j);
                }
            }
        }
    }

    /**
     * Test
     *
     * @param argv
     */
    public static void main(String argv[]) {

        int[] array = ArrayUtil.randomIntArray(50);
        InsertionSort.sort(array);
        System.out.println(ArrayUtil.arrayToString(array, 64));
    }
}
