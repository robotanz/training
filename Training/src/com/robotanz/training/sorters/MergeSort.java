package com.robotanz.training.sorters;

import com.robotanz.training.TestUtil;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * MergeSort: merge sort algorithm implementation. The average complexity is O(n log(n))
 * <p>
 * Created on 10 mai 2016
 *
 * @author Jgenti
 */
public class MergeSort implements ISorter {

    @Override
    public void sort(final int[] array) {
        sort(array, 0, array.length-1);
    }

    private void sort(final int[] array, final int first, final int last) {

        int length = last - first + 1;
        if(length < 8) {
            // for short arrays a simple sort is quite efficient
            InsertionSort.sort(array, first, last);
        }
        else {
            // split & recursive sort
            int middle = length /2;
            sort(array, first, first+middle);
            sort(array, first+middle+1, last);

            // merge
            int leftIndex = first; // left current index
            int rightIndex = first+middle+1; // right
            final int leftStopMark = rightIndex; // left stop index
            final int rightStopMark = last + 1;

            int[] buf = new int[length];
            for(int i=0; i<length; ++i) {
                // yieldLeft ? go ahead, yieldRight ? jump to else otherwise compare values
                if (rightIndex == rightStopMark || !(leftIndex == leftStopMark)
                        && array[leftIndex] < array[rightIndex]) {
                    buf[i] = array[leftIndex];
                    ++leftIndex;
                }
                else {
                    buf[i] = array[rightIndex];
                    ++rightIndex;
                }
            }

            // copy temporary buffer to the array range
            for(int i=0; i<length; ++i) {
                array[first + i] = buf[i];
            }
        }
    }

    public static void main(String[] args) {

        TestUtil.testSorter(new MergeSort(), 50000);
    }

}
