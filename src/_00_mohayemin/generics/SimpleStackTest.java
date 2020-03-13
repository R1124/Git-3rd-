package _00_mohayemin.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleStackTest {
    @Test
    void simpleStackDemoWithInt() {
        SimpleStack stack = new SimpleStack(10);
        stack.push(5);
        int item = stack.pop();
        Assertions.assertEquals(5, item);
    }
}
