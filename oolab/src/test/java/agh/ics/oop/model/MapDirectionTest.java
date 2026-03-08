package agh.ics.oop.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class MapDirectionTest {

    @Test
    void shouldReturnNextDirectionClockwise() {
        assertEquals(MapDirection.EAST,  MapDirection.NORTH.next(), "NORTH → EAST");
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next(),  "EAST → SOUTH");
        assertEquals(MapDirection.WEST,  MapDirection.SOUTH.next(), "SOUTH → WEST");
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next(),  "WEST → NORTH");
    }

    @Test
    void shouldReturnPreviousDirectionCounterClockwise() {
        assertEquals(MapDirection.WEST,  MapDirection.NORTH.previous(), "NORTH → WEST");
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous(),  "EAST → NORTH");
        assertEquals(MapDirection.EAST,  MapDirection.SOUTH.previous(), "SOUTH → EAST");
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous(),  "WEST → SOUTH");
    }

    @Test
    void shouldReturnCorrectUnitVectors() {
        assertEquals(new Vector2d(0, 1),  MapDirection.NORTH.toUnitVector());
        assertEquals(new Vector2d(1, 0),  MapDirection.EAST.toUnitVector());
        assertEquals(new Vector2d(0, -1), MapDirection.SOUTH.toUnitVector());
        assertEquals(new Vector2d(-1, 0), MapDirection.WEST.toUnitVector());
    }

    @Test
    void shouldReturnPolishNamesInToString() {
        assertEquals("Polnoc",  MapDirection.NORTH.toString());
        assertEquals("Wschod",  MapDirection.EAST.toString());
        assertEquals("Poludnie", MapDirection.SOUTH.toString());
        assertEquals("Zachod",  MapDirection.WEST.toString());
    }
}
