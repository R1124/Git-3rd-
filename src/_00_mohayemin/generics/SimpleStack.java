package _00_mohayemin.generics;

public class SimpleStack {
    private int[] container;
    private int topIndex;

    public SimpleStack(int size) {
        container = new int[size];
    }

    public void push(int item) {
        container[++topIndex] = item;
    }

    public int pop() {
        return container[topIndex--];
    }
}
