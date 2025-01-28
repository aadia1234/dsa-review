package algorithms.searching;

import datastructures.array.MyArray;

public class BinarySearch {

    public static <T extends Comparable<T>> int find(MyArray<T> array, T target) {
        return find(array, target, 0, array.getLength() - 1);
    }

    private static <T extends Comparable<T>> int find(MyArray<T> array, T target, int l, int r) {
        if (l <= r) {
            int mid = (l + r) / 2;
            T data = array.get(mid);

            if (target.compareTo(data) < 0) {
                return find(array, target, l, mid - 1);
            } else if (target.compareTo(data) > 0) {
                return find(array, target, mid + 1, r);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        MyArray<Integer> array = new MyArray<>();
        array.push(1);
        array.push(4);
        array.push(6);
        array.push(9);
        array.push(12);
        array.push(34);

        System.out.println("Index of '6': " + BinarySearch.find(array, 6));
    }
}
