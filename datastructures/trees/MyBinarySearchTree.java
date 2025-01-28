package datastructures.trees;

public class MyBinarySearchTree<T extends Comparable<T>> {
    protected MyBinarySearchTree<T> left;
    protected MyBinarySearchTree<T> right;
    protected T data;
    protected int length;

    private MyBinarySearchTree(T data) {
        this.left = null;
        this.right = null;
        this.data = data;
        this.length = 0;
    }

    public MyBinarySearchTree() {
        this(null);
    }

    public int insert(T data) {

        if (this.data == null) {
            this.data = data;
            return ++length;
        }

        if (this.data.compareTo(data) > 0) {
            if (left == null) {
                left = new MyBinarySearchTree<>(data);
            } else {
                left.insert(data);
            }
        } else {
            if (right == null) {
                right = new MyBinarySearchTree<>(data);
            } else {
                right.insert(data);
            }
        }

        return ++length;
    }

    public boolean lookup(T data) {
        if (this.data == null) {
            return false;
        }

        int compare = this.data.compareTo(data);

        if (compare == 0) {
            return true;
        } else if (compare < 0) {
            return right != null ? right.lookup(data) : false;
        } else {
            return left != null ? left.lookup(data) : false;
        }
    }

    public MyBinarySearchTree<T> getLeft() {
        return this.left;
    }

    public MyBinarySearchTree<T> getRight() {
        return this.right;
    }

    public T getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return TreePrinter.print(this);
    }

    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bst = new MyBinarySearchTree<>();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);

        System.out.println(bst.lookup(9));
        System.out.println(bst);
    }
}
