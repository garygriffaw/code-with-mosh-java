package com.garygriffaw.datastructures;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int value) {
        if(count == items.length) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }

        items[count] = value;
        count++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count; i++) {
            if (i < (items.length - 1))
                items[i] = items[i + 1];
        }

        count--;
    }

    public int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if (items[i] == value)
                return i;
        }

        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
