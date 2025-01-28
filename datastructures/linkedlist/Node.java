package datastructures.linkedlist;

public class Node<T> {
    protected Node<T> prev;
    protected Node<T> next;
    protected T data;

    public Node(T data) {
        this.data = data;
        prev = null;
        next = null;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
