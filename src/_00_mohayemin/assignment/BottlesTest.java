package _00_mohayemin.assignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BottlesTest {
    @Test
    public void verse_99()
    {
        String expected = "99 bottles of milk on the wall, 99 bottles of milk.\n"
                + "Take one down and pass it around, 98 bottles of milk on the wall.";
        String actual = new Bottles().verse(99);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void verse_2()
    {
        // TODO: implement this
    }

    @Test
    public void verse_1()
    {
        // TODO: implement this
    }

    @Test
    public void verse_0()
    {
        // TODO: implement this
    }
}
