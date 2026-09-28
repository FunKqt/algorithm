package structure;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node first;
    private int N;

    // Exercise 1.3.7 in page 162
    public T peak() {
        return first.item;
    }

    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    @Test
    public void Test() {
        StringBuilder stringBuilder = new StringBuilder();

        int N = 50;
        Stack<Integer> stack = new Stack<>();

        while (N > 0) {
            stack.push(N % 2);
            N /= 2;
        }

        for (int i : stack) {
            stringBuilder.append(i);
//            System.out.print(i);
        }

        String a = stringBuilder.toString();

        // 32 + 16 + 2
        Assert.assertEquals("110010", a);

    }
}