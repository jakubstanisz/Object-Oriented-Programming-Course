package agh.ics.oop.model;

import java.util.List;
import java.util.UUID;

public interface WorldMap extends MoveValidator {
    void place(Animal animal) throws IncorrectPositionException;
    void move(Animal animal, MoveDirection direction);
    boolean isOccupied(Vector2d position);
    WorldElement objectAt(Vector2d position);
    List<WorldElement> getElements();
    Boundary getCurrentBounds();
    UUID getId();
}