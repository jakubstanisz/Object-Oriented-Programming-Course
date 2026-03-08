package agh.ics.oop.model;

public class Animal implements WorldElement {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;

    public Animal() {
        this.position = new Vector2d(2, 2);
    }

    public Animal(Vector2d initialPosition) {
        this.position = initialPosition;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return switch (orientation) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case WEST -> "W";
            case EAST -> "E";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator validator) {
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector());
                if (validator.canMoveTo(newPosition)) {
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.orientation.toUnitVector());
                if (validator.canMoveTo(newPosition)) {
                    this.position = newPosition;
                }
            }
        }
    }
}