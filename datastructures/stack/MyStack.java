package datastructures.stack;

public class MyStack<T> {
    private Node<T> top;
    private Node<T> bottom;
    private int length;

    public MyStack() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    public T peek() {
        return top.data;
    }

    public int push(T data) {
        Node<T> node = new Node<>(data);

        if (bottom == null) {
            bottom = node;
        } else {
            node.next = top;
        }

        top = node;

        return ++length;
    }

    public T pop() {
        Node<T> old = top;
        top = top.next;
        old.next = null;
        length--;
        return old.data;
    }

    @Override
    public String toString() {
        String stackString = "";
        for (Node<T> curr = top; curr != null; curr = curr.next) {
            stackString += curr + (curr.next == null ? "" : " \n");
        }

        stackString = stackString.indent(6);

        return "{"
                + String.format("\nlength: %d, \ntop: %s, \nbottom: %s, \ndata: \n[\n%s\n] \n", length, top, bottom,
                        stackString)
                        .indent(6)
                + "}\n";
    }

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("Discord");
        stack.push("udemy");
        stack.push("google");
        stack.push("apple");
        stack.push("instagram");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack);
    }
}
