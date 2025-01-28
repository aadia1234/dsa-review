package datastructures.graph;

import datastructures.array.MyArray;
import datastructures.linkedlist.MyLinkedList;

public class MyGraph {
    private int count;
    private final MyArray<MyLinkedList<Integer>> adjacencyList;
    private final MyArray<MyArray<Boolean>> adjacencyMatrix;

    public MyGraph() {
        this.count = 0;
        this.adjacencyList = new MyArray<>();
        this.adjacencyMatrix = new MyArray<>();
    }

    public int addVertex(int node) {
        adjacencyList.push(new MyLinkedList<>());
        adjacencyMatrix.push(new MyArray<>());
        for (int i = 0; i < count; i++) {
            adjacencyMatrix.get(i).push(false);
            adjacencyMatrix.get(node).push(false);
        }
        return ++count;
    }

    public void addEdge(int node1, int node2) {
        MyLinkedList<Integer> list = adjacencyList.get(node1);
        list.append(node2);
        adjacencyMatrix.get(node1).set(node2, true);
    }

    public static void main(String[] args) {
        MyGraph graph = new MyGraph();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
    }
}
