package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void testGrassPlacement() {
        GrassField map = new GrassField(10);
        assertEquals(10, map.getElements().size());
    }

    @Test
    void testCanMoveTo() throws IncorrectPositionException {
        GrassField map = new GrassField(10);

        assertTrue(map.canMoveTo(new Vector2d(100, 100)));

        Animal animal = new Animal(new Vector2d(2, 2));
        map.place(animal);

        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
    }

    @Test
    void testObjectAtPriority() throws IncorrectPositionException {
        GrassField map = new GrassField(0);
        Vector2d pos = new Vector2d(2, 2);

        Animal animal = new Animal(pos);
        map.place(animal);

        assertTrue(map.objectAt(pos) instanceof Animal);
    }
}