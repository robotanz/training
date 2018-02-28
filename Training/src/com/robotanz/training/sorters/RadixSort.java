package com.robotanz.training.sorters;

import java.util.ArrayList;
import java.util.List;

import com.robotanz.training.TestUtil;

/**
 * This is an example of LSB Radix sort of positive or zero integers.
 * The List based implementation is not optimal and intend to show radix sort principles.
 * 
 * @author jgenti
 *
 */
public class RadixSort implements ISorter {

	@Override
	public void sort(int[] array) {

		int maxDigits = 1;
		
		// using List of Integer is not the most efficient
		final List<Integer>[] radixLists = createLists(10);
		
		int n = array.length;
		
		for(int j=0; j<maxDigits; ++j) {
			for(int i=0; i<n; ++i) {
				
				int number = array[i];
				
				// compute max number of digits at first pass
				if(j==0) {
					int nd = getNumDigits(number);
					if(nd > maxDigits) maxDigits = nd;
				}
				
				// sort jth digits from LSB
				int digit = getDigit(number, j);
				radixLists[digit].add(number);
			}
			
			// when done for j-th digit, recompose array
			int i = 0;
			for(List<Integer> list : radixLists) {
				for(int number : list) {
					array[i++] = number;
				}
			}
			
			// clear lists
			for(i=0; i<10; ++i) {
				radixLists[i].clear();
			}
		}
	}
	
	private List<Integer>[] createLists(int n) {
		final List<Integer>[] radixLists = new List[n];
		for(int i=0; i<n; ++i) {
			radixLists[i] = new ArrayList<>();
		}
		return radixLists;
	}
	
	private int getDigit(int number, int position) {
		
		int a = (int) Math.floor(number / Math.pow(10, position));
		int b = (int) (Math.floor(number / Math.pow(10, position + 1)) * 10);
		
		return  a - b;
 	}
	
	// number of digits in a positive number
	private int getNumDigits(int number) {
		int n = 0;
		do {
			number = number / 10;
			++n;
		}
		while(number != 0);
		
		return n;
	}
 
    /**
     * Test
     *
     * @param argv
     */
    public static void main(String argv[]) {

        TestUtil.testSorter(new RadixSort(), 50000);
    }
}
