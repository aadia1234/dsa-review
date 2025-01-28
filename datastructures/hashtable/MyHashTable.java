package datastructures.hashtable;

import datastructures.array.MyArray;
import datastructures.linkedlist.MyLinkedList;

public class MyHashTable<K, V> {
    private int capacity;
    private int size;
    private MyArray<MyLinkedList<Node<K, V>>> table;
    private MyArray<K> keys;
    private MyArray<V> values;

    public MyHashTable() {
        this(1);
    }

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        initTable();
    }

    // O(1)
    public int getSize() {
        return this.size;
    }

    // O(1)
    public MyArray<K> getKeys() {
        return this.keys;
    }

    // O(1)
    public MyArray<V> getValues() {
        return this.values;
    }

    // O(1) best case, O(N) worst case
    public int set(K key, V value) {
        MyLinkedList<Node<K, V>> bucket = getBucket(key);
        bucket.append(new Node<>(key, value));
        keys.push(key);
        values.push(value);

        if (++size == capacity) {
            capacity *= 2;
            refreshTable();
        }

        return size;
    }

    // O(1) best case, O(N) worst case
    public V get(K key) {
        MyLinkedList<Node<K, V>> bucket = getBucket(key);

        for (int i = 0; i < bucket.getLength(); i++) {
            Node<K, V> entry = bucket.get(i);

            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    // O(1) best case, O(N) worst case
    private void refreshTable() {
        MyArray<MyLinkedList<Node<K, V>>> oldTable = table;
        initTable();

        for (int i = 0; i < capacity; i++) {
            MyLinkedList<Node<K, V>> bucket = oldTable.get(i) != null ? oldTable.get(i) : new MyLinkedList<>();

            if (bucket != null) {
                for (int j = 0; j < bucket.getLength(); j++) {
                    Node<K, V> entry = bucket.get(j);
                    set(entry.key, entry.value);
                }
            }
        }

    }

    // O(N)
    private void initTable() {
        this.size = 0;
        this.table = new MyArray<>();
        this.keys = new MyArray<>();
        this.values = new MyArray<>();
    }

    private MyLinkedList<Node<K, V>> getBucket(K key) {
        int hashCode = hash(key);
        MyLinkedList<Node<K, V>> bucket = (hashCode < size) ? table.get(hashCode) : null;

        if (bucket == null) {
            bucket = new MyLinkedList<>();
            table.push(bucket);
        }

        return bucket;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    @Override
    public String toString() {
        return "{" + String.format("\ncapacity: %d, \nsize: %d, \nbuckets: \n%s \n", capacity, size, table).indent(6)
                + "}\n";

    }

    public static void main(String[] args) {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();
        hashTable.set("ta", 1000);
        hashTable.set("tu", 589);
        hashTable.set("e", 10);
        System.out.println(hashTable.getSize());
        System.out.println(hashTable.get("ta"));
        System.out.println(hashTable.get("tu"));
        System.out.println(hashTable.get("e"));
        System.out.println(hashTable);
        System.out.println("Keys: " + hashTable.getKeys());
        System.out.println("Values: " + hashTable.getValues());
    }
}
