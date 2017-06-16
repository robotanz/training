package com.robotanz.training.sorters;

import com.robotanz.training.TestUtil;

/**
 * BubbleSort example. Average O(n2), Best O(n)
 * 
 * @author jgenti
 *
 */
public class BubbleSort implements ISorter {

	@Override
	public void sort(int[] array) {

		int stop = array.length - 1;
		int next = 0;

		while(stop !=0) {
			for(int i=0; i<stop; ++i) {

				if(array[i] > array[i+1]) {
					swap(array, i);
					next = i;
				}
			}
			
			stop = next;
			next = 0;
		}
	}

	private void swap(int[] array, int i) {
		int tmp = array[i];
		array[i] = array[i + 1];
		array[i + 1] = tmp;
	}
	
    /**
     * Test
     *
     * @param argv
     */
    public static void main(String argv[]) {

        TestUtil.testSorter(new BubbleSort(), 50000);
    }
}
