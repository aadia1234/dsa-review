package datastructures.linkedlist;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /*
     * Doubly linked list solution
     * public void reverse() {
     * Node<T> temp = head;
     * for (Node<T> curr = tail; curr != null; curr = curr.prev) {
     * curr.next = curr.prev;
     * }
     * 
     * head = tail;
     * tail = temp;
     * }
     */

    /*
     * 
     * Singly linked list solution:
     * 
     * TIP: DRAW IT OUT!
     * 1 --> 10 --> 16 --> 88
     * 10 --> 1 --> 16 --> 88
     * 16 --> 10 --> 1 --> 88
     * 88 --> 16 --> 10 --> 1
     */

    public void reverse() {
        Node<T> curr = head, next = head.next, temp;
        tail = head;

        while (next != null) {
            temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }

        head.next = null;
        head = curr;
    }

    // O(1)
    public int append(T data) {
        Node<T> node = new Node<>(data);

        if (length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        return ++length;
    }

    // O(1)
    public int prepend(T data) {
        Node<T> node = new Node<>(data);

        if (length == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        return ++length;
    }

    // O(1)
    public T deleteHead() {
        Node<T> old = head;
        head = head.next;
        head.prev = null;
        old.next = null;
        length--;
        return old.data;
    }

    // O(1)
    public T deleteTail() {
        Node<T> old = tail;
        tail = tail.prev;
        tail.next = null;
        length--;
        old.prev = null;
        return old.data;
    }

    // O(N), O(1) at head and tail
    public int insert(int index, T data) {
        Node<T> node, curr;

        if (index == 0) {
            return prepend(data);
        } else if (index == length) {
            return append(data);
        } else {
            node = new Node<>(data);
            curr = lookup(index);

            curr.prev.next = node;
            node.prev = curr.prev;
            curr.prev = node;
            node.next = curr;

            return ++length;
        }
    }

    // O(N)
    public T remove(int index) {
        Node<T> node;

        if (index == 0) {
            return deleteHead();
        } else if (index == length - 1) {
            return deleteTail();
        } else {
            node = lookup(index);

            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            length--;

            return node.data;
        }
    }

    // O(N)
    public T get(int index) {
        return lookup(index).data;
    }

    // O(N)
    private Node<T> lookup(int index) {
        Node<T> curr = head;
        while (index-- > 0) {
            curr = curr.next;
        }

        return curr;
    }

    @Override
    public String toString() {
        String listString = "";
        for (Node<T> curr = head; curr != null; curr = curr.next) {
            listString += curr + (curr != tail ? " --> " : "");
        }
        return "{" + String.format("\nlength: %d, \nhead: %s, \ntail: %s, \nlist: %s", length, head, tail,
                listString).indent(6) + "}\n";
    }

    public int getLength() {
        return this.length;
    }

    public T getHead() {
        return this.head.data;
    }

    public T getTail() {
        return this.tail.data;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.prepend(10);
        linkedList.append(20);
        linkedList.append(30);
        linkedList.prepend(40);
        linkedList.prepend(50);
        linkedList.insert(2, 99);
        linkedList.remove(3);
        System.out.println(linkedList);
        linkedList.reverse();
        System.out.println(linkedList);
    }
}
