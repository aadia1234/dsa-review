package algorithms.dynamic_programming;

import datastructures.array.MyArray;

public class Fibonacci {

    public static int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int dynamicFib(int n) {
        MyArray<Integer> cache = new MyArray<>();
        cache.push(0);
        cache.push(1);
        for (int i = 0; i <= n - 2; i++) {
            cache.push(-1);
        }

        if (n >= 2) {
            return dynamicFib(cache, n);
        }

        return cache.get(n);
    }

    private static int dynamicFib(MyArray<Integer> cache, int n) {
        if (cache.get(n) == -1) {
            int fib1 = cache.get(n - 1) != -1 ? cache.get(n - 1) : dynamicFib(cache, n - 1);
            int fib2 = cache.get(n - 2) != -1 ? cache.get(n - 2) : dynamicFib(cache, n - 2);
            cache.set(n, fib1 + fib2);
        }

        return cache.get(n);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci.dynamicFib(45));
    }
}
