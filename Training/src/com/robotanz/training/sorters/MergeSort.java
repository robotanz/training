package com.robotanz.training.sorters;

import com.robotanz.training.ArrayUtil;

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
public class MergeSort {

    public void sort(final int[] array) {
        sort(array, 0, array.length-1);
    }

    private void sort(final int[] array, int first, int last) {

        int length = last - first + 1;
        if(length < 8) {
            // for short arrays a simple sort is quite efficient
            InsertionSort.sort(array, first, last);
        }
        else {
            // split & recursive sort
            int split = length /2;
            sort(array, first, first+split);
            sort(array, first+split+1, last);

            // merge
            int leftIndex = first; // left current index
            int rightIndex = first+split+1; // right
            int leftStopMark = rightIndex; // left stop index
            int rightStopMark = last+1;
            boolean yieldLeft = false; // when true, yields all left values remaining
            boolean yieldRight = false; // idem for right values

            int[] buf = new int[length];
            for(int i=0; i<length; ++i) {
                // yieldLeft ? go ahead, yieldRight ? jump to else otherwise compare values
                if(yieldLeft || !yieldRight && array[leftIndex] < array[rightIndex]) {
                    buf[i] = array[leftIndex];
                    ++leftIndex;

                    if(leftIndex == leftStopMark) {
                        //yieldLeft = false;
                        yieldRight = true;
                    }
                }
                else {
                    buf[i] = array[rightIndex];
                    ++rightIndex;
                    if(rightIndex == rightStopMark) {
                        yieldLeft = true;
                        //yieldRight = false;
                    }
                }
            }

            // copy temporary buffer to the array range
            for(int i=0; i<length; ++i) {
                array[first + i] = buf[i];
            }
        }
    }

    public static void main(String[] args) {

        int[] array = ArrayUtil.randomIntArray(32);

        MergeSort sorter = new MergeSort();
        sorter.sort(array);

        System.out.println(ArrayUtil.arrayToString(array, 64));
    }

}
