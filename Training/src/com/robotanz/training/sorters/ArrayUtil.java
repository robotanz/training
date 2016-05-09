package com.robotanz.training.sorters;

public class ArrayUtil {

    public ArrayUtil() {
    }

    public static void swap(int[] array, int index0, int index1) {
        int value = array[index0];
        array[index0] = array[index1];
        array[index1] = value;
    }
}
