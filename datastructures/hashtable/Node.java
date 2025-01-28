package datastructures.hashtable;

public class Node<K, V> {
    public K key;
    public V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("{%s, %s}", key, value);
    }
}
