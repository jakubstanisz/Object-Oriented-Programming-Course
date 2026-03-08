package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testEquals() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(2, 1);

        assertTrue(v1.equals(v2));
        assertFalse(v1.equals(v3));
        assertFalse(v1.equals(null));
        assertFalse(v1.equals(new Object()));
    }

    @Test
    void testToString() {
        Vector2d v = new Vector2d(1, 2);
        assertEquals("(1,2)", v.toString());
    }

    @Test
    void testPrecedes() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);

        assertTrue(v1.precedes(v2));
        assertFalse(v2.precedes(v1));
    }

    @Test
    void testFollows() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);

        assertFalse(v1.follows(v2));
        assertTrue(v2.follows(v1));
    }

    @Test
    void testUpperRight() {
        Vector2d v1 = new Vector2d(1, 5);
        Vector2d v2 = new Vector2d(4, 2);
        assertEquals(new Vector2d(4, 5), v1.upperRight(v2));
    }

    @Test
    void testLowerLeft() {
        Vector2d v1 = new Vector2d(1, 5);
        Vector2d v2 = new Vector2d(4, 2);
        assertEquals(new Vector2d(1, 2), v1.lowerLeft(v2));
    }

    @Test
    void testAdd() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);
        assertEquals(new Vector2d(3, 5), v1.add(v2));
    }

    @Test
    void testSubtract() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);
        assertEquals(new Vector2d(-1, -1), v1.subtract(v2));
    }

    @Test
    void testOpposite() {
        Vector2d v = new Vector2d(1, 2);
        assertEquals(new Vector2d(-1, -2), v.opposite());
    }
}