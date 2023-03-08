package Algorithmics.homework;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] numbers = {9, 8, 2, 3, 5, 6, 9, 4, 6, 2, 7, 9, 1, 0};
        System.out.println("Start: " + Arrays.toString(numbers));

        heapSort(numbers);
        System.out.println("Final: " + Arrays.toString(numbers));
    }

    private static void heapSort(int[] number) {
        heapSort(number, number.length);
    }

    private static void heapSort(int[] number, int size) {
        if (size == 1) {
            return;
        }

        for (int i = size / 2 - 1; i >= 0; i--) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            if (left < size && number[i] < number[left]) {
                swap(number, i, left);
            }

            if (right < size && number[i] < number[right]) {
                swap(number, i, right);
            }
        }

        swap(number, 0, --size);
        heapSort(number, size);
    }

    private static void swap(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }
}
