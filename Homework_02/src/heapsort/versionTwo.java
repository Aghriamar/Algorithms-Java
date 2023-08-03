package heapsort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class versionTwo {

    public static int[] createArray() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter length array");
        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 20);
        }
        System.out.println("Create random array: " + Arrays.toString(array));
        return array;
    }

    public static void heapSort(int[] array) {
        heapBuild(array);
        for (int i = array.length - 1; i >= 1; i--)
        {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            int heapSize = i;
            build(array, 0, heapSize);
        }
        System.out.println("Finish: " + Arrays.toString(array));
    }

    // build heap
    private static void heapBuild(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            build(array, i, array.length);
        }
    }

    // conversion to binary heap
    private static void build(int[] array, int i, int length) {
        int large = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < length && array[left] > array[large]) {
            large = left;
        }
        if (right < length && array[right] > array[large]) {
            large = right;
        }
        if (large != i) {
            int temp = array[i];
            array[i] = array[large];
            array[large] = temp;
            build(array, large, length);
        }
    }
}
