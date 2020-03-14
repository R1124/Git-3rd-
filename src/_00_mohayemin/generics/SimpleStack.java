package _00_mohayemin.generics;

public class SimpleStack<TItem>
{
    private Object[] container;
    private int topIndex;

    public SimpleStack(int size)
    {
        container = new Object[size];
    }

    public void push(TItem item)
    {
        container[++topIndex] = item;
    }

    public TItem pop()
    {
        return (TItem)container[topIndex--];
    }
}
