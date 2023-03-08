package Algorithmics.homework;

import java.util.Arrays;

public class HeapSortCycles {
    public static void main(String[] args) {
        int[] numbers = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println("Start: " + Arrays.toString(numbers));

        heapSort(numbers);
        System.out.println("Final: " + Arrays.toString(numbers));
    }

    private static void heapSort(int[] numbers) {
        if (numbers.length == 1) return;

        int size = numbers.length;

        for (int j = 0; j < numbers.length; j++) {

            if (sifting(numbers, size)) {
                swap(numbers, 0, --size);
            } else {
                break;
            }
        }
    }

    static boolean sifting(int[] array, int size) {
        boolean isSwap = false;
        for (int i = size / 2 - 1; i >= 0; i--) {
            int leftIndex = i * 2 + 1;
            int rightIndex = i * 2 + 2;

            if (leftIndex < size && array[leftIndex] > array[i]) {
                swap(array, leftIndex, i);
                isSwap = true;
            }


            if (rightIndex < size && array[rightIndex] > array[i]) {
                swap(array, i, rightIndex);
                isSwap = true;
            }
        }

        return isSwap;
    }

    static void swap(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }
}
