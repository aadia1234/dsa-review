package algorithms.sorting;

import datastructures.array.MyArray;

public class MyMergeSort {
    public static <T extends Comparable<T>> void sort(MyArray<T> array) {
        mergesort(array, 0, array.getLength()-1);
    }

    private static <T extends Comparable<T>> void mergesort(MyArray<T> array, int l, int r) {

        if (l < r) {
            int mid = (l + r) / 2;
            mergesort(array, l, mid);
            mergesort(array, mid + 1, r);
            merge(array, l, mid, r);
        }
    }

    private static <T extends Comparable<T>> void merge(MyArray<T> array, int l, int mid, int r) {
        
    }

    public static void main(String[] args) {
        MyArray<Integer> array = new MyArray<>();
        array.push(6);
        array.push(5);
        array.push(3);
        array.push(1);
        array.push(8);
        array.push(7);
        array.push(2);
        array.push(4);

        MyMergeSort.sort(array);
        System.out.println(array);
    }
}
