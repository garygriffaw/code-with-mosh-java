package com.garygriffaw.datastructures;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items = new int[5];
    private int count;

    public void add(int item) {
        if (isFull()) {
            int[] newItems = new int[items.length * 2];
            for (int i = 0; i < items.length; i++)
                newItems[i] = items[i];
            items = newItems;
        }

        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;

    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        int item = items[count - 1];
        items[count - 1] = 0;
        count--;
        return item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    public boolean isFull() {
        return count == items.length;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = (count - 1); i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else {
                break;
            }
        }
        return i + 1;
    }
}
