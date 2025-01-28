package algorithms.searching;

import datastructures.array.MyArray;
import datastructures.queue.MyQueue;
import datastructures.trees.MyBinarySearchTree;

public class BreadthFirstSearch {

    public static <T extends Comparable<T>> MyArray<T> search(MyBinarySearchTree<T> tree) {
        MyQueue<MyBinarySearchTree<T>> queue = new MyQueue<>();
        queue.enqueue(tree);
        return search(tree, new MyArray<>(), queue);
    }

    private static <T extends Comparable<T>> MyArray<T> search(MyBinarySearchTree<T> tree, MyArray<T> output, MyQueue<MyBinarySearchTree<T>> queue) {

        if (tree == null) { return output; }

        MyBinarySearchTree<T> left = tree.getLeft();
        MyBinarySearchTree<T> right = tree.getRight();

        output.push(tree.getData());
        queue.enqueue(left);
        queue.enqueue(right);


        if (queue.getLength() > 0) {
            queue.dequeue();
            MyBinarySearchTree<T> next = queue.peek();
            return search(next, output, queue);
        } else {
            return output;
        }
    }

    public static void main(String[] args) {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);

        System.out.println(tree);
        System.out.println("BFS: \n" + BreadthFirstSearch.search(tree));
    }
}
