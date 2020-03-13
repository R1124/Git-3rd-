package _00_mohayemin.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleStackTest {
    @Test
    void simpleStackDemoWithInt() {
        SimpleStack stack = new SimpleStack(10);
        stack.push(5);
        int item = (int) stack.pop();
        Assertions.assertEquals(5, item);
    }

    @Test
    void simpleStackDemoWithString() {
        SimpleStack stack = new SimpleStack(10);
        stack.push("alpha");
        String item = (String) stack.pop();
        Assertions.assertEquals("ALPHA", item.toUpperCase());
    }

    @Test
    void simpleStackDemo_DoingItWrong() {
        // This test will fail
        SimpleStack stack = new SimpleStack(10);
        stack.push(55);
        String item = (String) stack.pop(); // This line will through error in runtime
        Assertions.assertEquals("ALPHA", item.toUpperCase());
    }
}
