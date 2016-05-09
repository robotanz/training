package com.robotanz.training.sorters;

public class MergeSort {
	
	public void sort(final int[] array) {
		sort(array, 0, array.length-1);
	}
	
	private void sort(final int[] array, int start, int end) {
		
		int length = end - start + 1;
		if(length < 8) {
			selectSort(array, start, end);
		}
		else {
			// split & recursive sort
			int split = length /2;
			sort(array, start, start+split);
			sort(array, start+split+1, end);
			
			// merge
			int leftIndex = start; // left current index
			int rightIndex = start+split+1; // right
			int leftStopMark = rightIndex; // left stop index
			int rightStopMark = end+1;
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
				array[start + i] = buf[i];
			}
		}
	}
	
	private void selectSort(int[] array, int start, int end) {
		
		if(start == end) {
			return;
		}
		else if(end - start == 1) {
			if(array[start] > array[end]) {
				ArrayUtil.swap(array, start, end);
			}
			return;
		}
		else {
		
			for(int i=start; i<end; ++i) {
				for(int j=i+1; j<=end; ++j) {
					if(array[i] > array[j]) {
						ArrayUtil.swap(array, i, j);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
        int[] array = new int[32];

        for (int i = 0; i < array.length; ++i) {
            array[i] = (int) Math.floor(Math.random() * 32);
        }

        MergeSort sorter = new MergeSort();
        sorter.sort(array);

        System.out.println(array);
	}

}
