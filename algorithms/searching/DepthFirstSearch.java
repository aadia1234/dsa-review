package algorithms.searching;

import datastructures.array.MyArray;
import datastructures.trees.MyBinarySearchTree;

public class DepthFirstSearch {

    public static <T extends Comparable<T>> MyArray<T> preOrderSearch(MyBinarySearchTree<T> tree) {
        return preOrderSearch(tree, new MyArray<>());
    }

    private static <T extends Comparable<T>> MyArray<T> preOrderSearch(MyBinarySearchTree<T> tree, MyArray<T> output) {
        if (tree == null) {
            return output;
        }

        output.push(tree.getData());
        preOrderSearch(tree.getLeft(), output);
        preOrderSearch(tree.getRight(), output);

        return output;
    }

    public static <T extends Comparable<T>> MyArray<T> inOrderSearch(MyBinarySearchTree<T> tree) {
        return inOrderSearch(tree, new MyArray<>());
    }

    private static <T extends Comparable<T>> MyArray<T> inOrderSearch(MyBinarySearchTree<T> tree, MyArray<T> output) {
        if (tree == null) {
            return output;
        }

        inOrderSearch(tree.getLeft(), output);
        output.push(tree.getData());
        inOrderSearch(tree.getRight(), output);

        return output;
    }

    public static <T extends Comparable<T>> MyArray<T> postOrderSearch(MyBinarySearchTree<T> tree) {
        return postOrderSearch(tree, new MyArray<>());
    }

    private static <T extends Comparable<T>> MyArray<T> postOrderSearch(MyBinarySearchTree<T> tree, MyArray<T> output) {
        if (tree == null) {
            return output;
        }

        postOrderSearch(tree.getLeft(), output);
        postOrderSearch(tree.getRight(), output);
        output.push(tree.getData());

        return output;
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
        System.out.println("DFS, Pre-order traversal: \n" + DepthFirstSearch.preOrderSearch(tree));
        System.out.println("DFS, In-order traversal: \n" + DepthFirstSearch.inOrderSearch(tree));
        System.out.println("DFS, Post-order traversal: \n" + DepthFirstSearch.postOrderSearch(tree));
    }
}
