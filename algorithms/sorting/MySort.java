package algorithms.sorting;

import datastructures.array.MyArray;

public class MySort {

    public static <T extends Comparable<T>> void bubblesort(MyArray<T> array) {
        int length = array.getLength();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                T num1 = array.get(j);
                T num2 = array.get(j + 1);
                if (num1.compareTo(num2) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void selectionsort(MyArray<T> array) {
        int length = array.getLength();
        for (int i = 0; i < length; i++) {
            int pos = i;
            for (int j = i + 1; j < length; j++) {
                if (array.get(pos).compareTo(array.get(j)) > 0) {
                    pos = j;
                }
            }
            swap(array, i, pos);
        }
    }

    public static <T extends Comparable<T>> void insertionsort(MyArray<T> array) {
        int length = array.getLength();
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            T key = array.get(i);
            while (j >= 0 && array.get(j).compareTo(key) > 0) {
                array.set(j + 1, array.get(j));
                j--;
            }
            array.set(j + 1, key);
        }
    }

    private static <T extends Comparable<T>> void swap(MyArray<T> array, int i, int j) {
        T t1 = array.get(i);
        T t2 = array.get(j);
        array.set(i, t2);
        array.set(j, t1);
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

        MySort.insertionsort(array);
        System.out.println(array);
    }
}
