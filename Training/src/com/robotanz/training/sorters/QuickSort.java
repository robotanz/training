package com.robotanz.training.sorters;

import com.robotanz.training.ArrayUtil;
import com.robotanz.training.TestUtil;


/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * QuickSort: Basic QuickSort single threaded implementation, could be multi-threaded as well. The
 * average complexity is O(n log(n))
 * <p>
 * Created on 9 mai 2016
 *
 * @author Jgenti
 */
public class QuickSort implements ISorter {

    public QuickSort() {
        super();
    }

    public int[] sort(final int[] array, final int first, final int last) {

        int length = last - first + 1;
        if (length > 2) {

            // split
            int pivot = (int) Math.floor(Math.random() * length) + first;
            ArrayUtil.swap(array, pivot, last);

            int index = first;
            for (int i = first; i < last; ++i) {
                // si plus petit que la valeur pivot, alors on la déplace vers l'avant
                if (array[i] < array[last]) {
                    ArrayUtil.swap(array, i, index);
                    ++index;
                }
            }

            ArrayUtil.swap(array, index, last);

            // sort
            sort(array, first, index);
            sort(array, index + 1, last);
        }
        else if (length == 2) {
            if (array[last] < array[first]) {
                ArrayUtil.swap(array, first, last);
            }
        }

        return array;
    }

    /**
     * Test
     *
     * @param argv
     */
    public static void main(String argv[]) {

        TestUtil.testSorter(new QuickSort(), 2000);
    }

    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }
}
