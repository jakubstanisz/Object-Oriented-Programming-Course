package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void testOrientation() {
        Animal animal = new Animal();
        assertEquals(MapDirection.NORTH, animal.getOrientation());

        MoveValidator validator = new RectangularMap(5, 5);

        animal.move(MoveDirection.RIGHT, validator);
        assertEquals(MapDirection.EAST, animal.getOrientation());

        animal.move(MoveDirection.RIGHT, validator);
        assertEquals(MapDirection.SOUTH, animal.getOrientation());

        animal.move(MoveDirection.RIGHT, validator);
        assertEquals(MapDirection.WEST, animal.getOrientation());

        animal.move(MoveDirection.RIGHT, validator);
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void testPositionAndMovement() {
        Animal animal = new Animal(new Vector2d(2, 2));
        MoveValidator validator = new RectangularMap(5, 5);

        animal.move(MoveDirection.FORWARD, validator);
        assertEquals(new Vector2d(2, 3), animal.getPosition());

        animal.move(MoveDirection.FORWARD, validator);
        assertEquals(new Vector2d(2, 4), animal.getPosition());

        animal.move(MoveDirection.FORWARD, validator);
        assertEquals(new Vector2d(2, 4), animal.getPosition());

        animal.move(MoveDirection.BACKWARD, validator);
        assertEquals(new Vector2d(2, 3), animal.getPosition());
    }

    @Test
    void testIsAt() {
        Animal animal = new Animal(new Vector2d(2, 2));
        assertTrue(animal.isAt(new Vector2d(2, 2)));
        assertFalse(animal.isAt(new Vector2d(3, 2)));
    }
}