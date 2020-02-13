package _00_mohayemin.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTest{
    @Test
    void test1(){
        Rectangle r = new Rectangle();
        r.setWidth(3);
        r.setHeight(4);

        Assertions.assertEquals(12, r.area());
    }

    @Test
    void testSquare(){
        Square s = new Square();
        s.setLength(6);
        Assertions.assertEquals(25, s.area());
    }
}
