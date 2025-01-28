package datastructures.queue;

public class MyQueue<T> {
    private Node<T> first;
    private Node<T> last;
    private int length;

    public MyQueue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public T peek() {
        return first != null ? first.data : null;
    }

    public int enqueue(T data) {
        Node<T> node = new Node<>(data);

        if (first == null) {
            first = node;
        } else {
            last.next = node;
        }

        last = node;

        return ++length;
    }

    public T dequeue() {
        Node<T> old = first;
        first = first.next;
        old.next = null;
        length--;
        return old.data;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public String toString() {
        String stackString = "";
        for (Node<T> curr = first; curr != null; curr = curr.next) {
            stackString += curr + (curr.next == null ? "" : " \n");
        }

        stackString = stackString.indent(6);

        return "{"
                + String.format("\nlength: %d, \nfirst: %s, \nlast: %s, \ndata: \n[\n%s\n] \n", length, first, last,
                        stackString)
                        .indent(6)
                + "}\n";
    }

    public static void main(String[] args) {
        MyQueue<String> stack = new MyQueue<>();
        stack.enqueue("Discord");
        stack.enqueue("udemy");
        stack.enqueue("google");
        stack.enqueue("apple");
        stack.enqueue("instagram");
        System.out.println(stack.peek());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());

        System.out.println(stack);
    }
}
