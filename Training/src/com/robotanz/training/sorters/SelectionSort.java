package com.robotanz.training.sorters;

import com.robotanz.training.ArrayUtil;
import com.robotanz.training.TestUtil;

/**
 * SelectionSort: simple selection sort algorithm with general O(n²) complexity
 */
public class SelectionSort implements ISorter {

    /**
     * Sort the given array
     *
     * @param array
     */
    @Override
    public void sort(int[] array) {
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

            // Actual selection sort begins here:

            // for the i as current position
            for (int i = first; i < last; ++i) {
                // iterate on subsequent positions and compare, then swap if necessary
                for (int j = i + 1; j <= last; ++j) {
                    if (array[i] > array[j]) {
                        ArrayUtil.swap(array, i, j);
                    }
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
        TestUtil.testSorter(new SelectionSort(), 50000);
    }
}
