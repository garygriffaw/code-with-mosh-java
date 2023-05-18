package com.garygriffaw.datastructures;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size;

    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = null;
            last = null;
        } else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = null;
            last = null;
        } else {
            last = getPrevious(last);
            last.next = null;
        }

        size--;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while (current != null) {
              if (current.value == item)
                  return index;
              index++;
              current = current.next;
        }

        return -1;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        var index = 0;

        while (current != null) {
            array[index] = current.value;
            index++;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        if (isEmpty())
            return;

        var oldFirst = first;
        var prev = first;
        var current = first.next;

        while (current != null) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        first = last;
        last = oldFirst;
        last.next = null;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var node2 = first;
        for (int i = 0; i < (k - 1); i++) {
            node2 = node2.next;
            if (node2 == null)
                throw new IllegalArgumentException();
        }

        var node1 = first;
        while (node2 != last) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1.value;
    }

    private Node getPrevious(Node node) {
        var current = first;

        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }

        return null;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
