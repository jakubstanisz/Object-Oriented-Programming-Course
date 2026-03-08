package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void testPlaceAndIsOccupied() throws IncorrectPositionException {
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        map.place(animal);

        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertEquals(animal, map.objectAt(new Vector2d(2, 2)));
    }

    @Test
    void testPlaceDuplicate() throws IncorrectPositionException {
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal1 = new Animal(new Vector2d(2, 2));
        Animal animal2 = new Animal(new Vector2d(2, 2));

        map.place(animal1);

        assertThrows(IncorrectPositionException.class, () -> map.place(animal2));
    }

    @Test
    void testCanMoveTo() throws IncorrectPositionException {
        RectangularMap map = new RectangularMap(4, 4);
        map.place(new Animal(new Vector2d(2, 2)));

        assertTrue(map.canMoveTo(new Vector2d(1, 1)));
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
        assertFalse(map.canMoveTo(new Vector2d(5, 5)));
    }
}