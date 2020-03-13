package _00_mohayemin.generics;

public class SimpleStack {
    private Object[] container;
    private int topIndex;

    public SimpleStack(int size) {
        container = new Object[size];
    }

    public void push(Object item) {
        container[++topIndex] = item;
    }

    public Object pop() {
        return container[topIndex--];
    }
}
