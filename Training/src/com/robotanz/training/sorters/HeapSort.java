package com.robotanz.training.sorters;

import com.robotanz.training.ArrayUtil;
import com.robotanz.training.TestUtil;

/**
 * HeapSort: Heap sort implementation using a max heap and sift down technique. Average O(n log n).
 */
public class HeapSort implements ISorter {

    @Override
    public void sort(int[] array) {

        // first build a max heap (largest element will be the root (index 0))
        // this stage will have O(n) complexity
        buildMaxHeap(array);

        // heap sort in itself is simply this O(n log n):

        for (int end = array.length - 1; end > 0; --end) {

            // put the largest values taken from the heap root to the decremented end positions
            ArrayUtil.swap(array, end, 0);

            // restore the heap for remaining positions (except the sorted ones at the end)
            // to "rootify" the remaining largest value :)
            siftDown(array, 0, end - 1);
        }
    }

    private void buildMaxHeap(final int[] array) {

        // start with the parent of the last node
        int start = parent(array.length - 1);
        // iterate on parent nodes upwards
        while (start >= 0) {
            siftDown(array, start, array.length - 1);
            --start;
        }
    }

    /**
     * Restores heap property from the start node and below if necessary. Makes sure the start index
     * holds the largest value coming from its children.
     *
     * @param array
     * @param start start index
     * @param end last index in the heap
     */
    private void siftDown(final int[] array, int start, int end) {

        int currentParent = start;

        while (leftChild(currentParent) <= end) {
            // begin with the left child
            int child = leftChild(currentParent);
            // assume current parent is the largest: no need to swap then
            int largestValueIndex = currentParent;

            // compare parent with left child
            if (array[child] > array[currentParent]) {
                // if child is larger it is marked to be swapped
                largestValueIndex = child;
            }
            // next (right) child
            ++child;
            if (child <= end && array[child] > array[largestValueIndex]) {
                // if child is larger than previous largest value it is marked to be swapped
                largestValueIndex = child;
            }

            if (largestValueIndex == currentParent) {
                // nothing to swap and lower nodes are already consistent
                return;
            }
            else {
                // swap parent with the largest child
                ArrayUtil.swap(array, largestValueIndex, currentParent);
                // then continue downwards with this former largest child
                currentParent = largestValueIndex;
            }
        }
    }

    /**
     * Parent's index for the given child's index
     *
     * @param childIndex
     * @return
     */
    private int parent(int childIndex) {
        return (int) Math.floor((childIndex - 1) / 2);
    }

    /**
     * Index of the left child, for the right child add 1 to this index
     *
     * @param parentIndex
     * @return
     */
    private int leftChild(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    public static void main(String[] args) {
        TestUtil.testSorter(new HeapSort(), 50000);
    }
}
