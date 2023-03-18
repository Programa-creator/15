package org.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 8, 1, 3, 9, 6};

        int[] quickSortArr = Arrays.copyOf(arr, arr.length);
        quickSort(quickSortArr, 0, quickSortArr.length - 1);
        System.out.println("Швидке сортування: " + Arrays.toString(quickSortArr));

        int[] shakerSortArr = Arrays.copyOf(arr, arr.length);
        shakerSort(shakerSortArr);
        System.out.println("Шейкерне сортування: " + Arrays.toString(shakerSortArr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }

    public static void shakerSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
            left++;
        }
    }
}