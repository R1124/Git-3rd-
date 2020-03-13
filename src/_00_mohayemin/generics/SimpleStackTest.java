package _00_mohayemin.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleStackTest {
    @Test
    void simpleStackDemoWithInt() {
        SimpleStack<Integer> stack = new SimpleStack<>(10);
        stack.push(5);
        int item = stack.pop();
        Assertions.assertEquals(5, item);
    }

    @Test
    void simpleStackDemoWithString() {
        SimpleStack<String> stack = new SimpleStack<>(10);
        stack.push("alpha");
        String item = stack.pop();
        Assertions.assertEquals("ALPHA", item.toUpperCase());
    }

    @Test
    void simpleStackDemo_DoingItWrong() {
        // This test will fail
        SimpleStack<String> stack = new SimpleStack<>(10);
        //stack.push(55); // Now this will not compile!
        //String item = (String) stack.pop();
        //Assertions.assertEquals("ALPHA", item.toUpperCase());
    }
}
