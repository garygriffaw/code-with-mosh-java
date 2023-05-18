package com.garygriffaw.datastructures;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> enqueueStack = new Stack<>();
    private Stack<Integer> dequeueStack = new Stack<>();

    public void enqueue(int item) {
        enqueueStack.push(item);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStackValues();

        return dequeueStack.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStackValues();

        return dequeueStack.peek();
    }

    public boolean isEmpty() {
        return dequeueStack.isEmpty() && enqueueStack.isEmpty();
    }

    private void moveStackValues() {
        if (dequeueStack.isEmpty())
            while (!enqueueStack.isEmpty())
                dequeueStack.push(enqueueStack.pop());
    }

    @Override
    public String toString() {
        return enqueueStack + " " + dequeueStack;
    }
}
