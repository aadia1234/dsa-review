package algorithms;

import datastructures.array.MyArray;
import datastructures.hashtable.MyHashTable;

public class FirstRecurringCharacter {

    public static <T> T getFirstRecurringCharacter(MyArray<T> array) {
        MyHashTable<T, Integer> table = new MyHashTable<>();

        for (int i = 0; i < array.getLength(); i++) {
            T item = array.get(i);
            if (table.get(item) != null) {
                return item;
            } else {
                table.set(item, i);
            }
        }
        return null;
    }

    public static <T> MyArray<T> convert(T[] array) {
        MyArray<T> myArray = new MyArray<>();
        for (T item : array) {
            myArray.push(item);
        }
        return myArray;
    }

    public static void main(String[] args) {
        Integer[] array1 = { 2, 5, 1, 2, 3, 5, 1, 2, 4 };
        Integer[] array2 = { 2, 1, 1, 2, 3, 5, 1, 2, 4 };
        Integer[] array3 = { 2, 3, 4, 5 };
        Integer[] array4 = { 1, 5, 8, 5, 1, 8, 8, 7, 4, 4, 10 };
        Integer[] array5 = { 2, 5, 5, 2, 3, 5, 1, 2, 4 };
        System.out.println(getFirstRecurringCharacter(convert(array1)));
        System.out.println(getFirstRecurringCharacter(convert(array2)));
        System.out.println(getFirstRecurringCharacter(convert(array3)));
        System.out.println(getFirstRecurringCharacter(convert(array4)));
        System.out.println(getFirstRecurringCharacter(convert(array5)));
    }
}
