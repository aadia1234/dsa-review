package algorithms;

import datastructures.array.MyArray;

public class MergeSortedArrays {

    // O(N + M)
    public static <T extends Comparable<T>> MyArray<T> merge(MyArray<T> array1, MyArray<T> array2) {
        MyArray<T> mergedArray = new MyArray<>();
        int index1 = 0, index2 = 0;
        T item1, item2;

        do {
            item1 = array1.get(index1);
            item2 = array2.get(index2);

            if ((item1 != null) && (item2 == null || item1.compareTo(item2) < 0)) {
                mergedArray.push(item1);
                index1++;
            } else if (item2 != null) {
                mergedArray.push(item2);
                index2++;
            }

        } while (item1 != null || item2 != null);

        return mergedArray;
    }

    public static void main(String[] args) {
        MyArray<Integer> array1 = new MyArray<>();
        MyArray<Integer> array2 = new MyArray<>();

        array1.push(1);
        array1.push(1);
        array1.push(8);
        array1.push(9);
        array1.push(10);

        array2.push(1);
        array2.push(2);
        array2.push(8);
        array2.push(9);
        array2.push(11);
        array2.push(15);
        array2.push(16);

        MyArray<Integer> mergedArray = merge(array1, array2);

        System.out.println(mergedArray);
    }
}
