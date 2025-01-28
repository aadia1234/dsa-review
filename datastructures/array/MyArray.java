package datastructures.array;

import java.util.Arrays;

public class MyArray<T> {
    protected int capacity;
    protected int length;
    protected T[] data;

    @SuppressWarnings("unchecked")
    public MyArray() {
        this.capacity = 1;
        this.length = 0;
        this.data = (T[]) new Object[1];
    }

    // O(1)
    public int getLength() {
        return this.length;
    }

    // O(1)
    public T get(int index) {
        return data[index];
    }

    // O(1)
    public T set(int index, T item) {
        T old = data[index];
        data[index] = item;
        return old;
    }

    // O(1) average case, O(N) worst case
    public int push(T item) {
        data[length++] = item;

        if (length == capacity) {
            capacity *= 2;
            data = Arrays.copyOf(data, capacity * 2);
        }

        return length;
    }

    // O(1)
    public T pop() {
        T item = data[--length];
        data[length] = null;
        return item;
    }

    // O(N)
    public T delete(int index) {
        T item = data[index];
        shiftLeft(index);
        length--;
        return item;
    }

    public int insert(int index, T item) {
        push(item);
        shiftRight(index);
        data[index] = item;
        return ++length;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }

        data[length - 1] = null;
    }

    private void shiftRight(int index) {
        for (int i = length - 2; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = null;
    }

    @Override
    public String toString() {
        String dataString = "";
        for (int i = 0; i < length; i++) {
            dataString += data[i] + (i == length - 1 ? "" : " \n");
        }
        dataString = dataString.indent(6);
        return "{"
                + String.format("\ncapacity: %d, \nlength: %d, \ndata: \n[\n%s\n] \n", capacity, length, dataString)
                        .indent(6)
                + "}\n";
    }

    public static void main(String[] args) {
        MyArray<Integer> array = new MyArray<>();

        array.push(50);
        array.push(40);
        array.push(60);
        array.push(20);

        array.pop();

        System.out.println(array);
    }
}