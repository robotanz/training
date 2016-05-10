package com.robotanz.training;

public class ArrayUtil {

    public static void swap(int[] array, int index0, int index1) {
        int value = array[index0];
        array[index0] = array[index1];
        array[index1] = value;
    }

    public static int[] randomIntArray(final int size) {
        int[] array = new int[size];

        for (int i = 0; i < array.length; ++i) {
            array[i] = (int) Math.floor(Math.random() * size);
        }

        return array;
    }

    /**
     * Formats an array for pretty print output
     *
     * @param array
     * @param maxCount maximal number of displayed values
     * @return
     */
    public static String arrayToString(int[] array, int maxCount) {

        int length = array.length;
        int last = length - 1;

        if (length > maxCount) {
            length = maxCount;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i < length; ++i) {
            builder.append(array[i]);
            if (i < last) {
                builder.append(", ");
            }
        }

        if (length <= last) {
            builder.append("...");
        }

        builder.append("]");

        return builder.toString();
    }
}
