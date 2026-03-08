package agh.ics.oop.model;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final MapVisualizer visualizer = new MapVisualizer(this);
    private final List<MapChangeListener> observers = new ArrayList<>();
    private final UUID id = UUID.randomUUID();

    public void addObserver(MapChangeListener observer) {
        observers.add(observer);
    }

    public void removeObserver(MapChangeListener observer) {
        observers.remove(observer);
    }

    protected void mapChanged(String message) {
        for (MapChangeListener observer : observers) {
            observer.mapChanged(this, message);
        }
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void place(Animal animal) throws IncorrectPositionException {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            mapChanged("Animal placed at " + animal.getPosition());
        } else {
            throw new IncorrectPositionException(animal.getPosition());
        }
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (animals.get(animal.getPosition()) == animal) {
            Vector2d oldPosition = animal.getPosition();
            MapDirection oldOrientation = animal.getOrientation();

            animals.remove(oldPosition);
            animal.move(direction, this);
            animals.put(animal.getPosition(), animal);

            if (!oldPosition.equals(animal.getPosition()) || oldOrientation != animal.getOrientation()) {
                mapChanged("Animal moved from " + oldPosition + " to " + animal.getPosition());
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public List<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }

    @Override
    public String toString() {
        Boundary boundary = getCurrentBounds();
        return visualizer.draw(boundary.lowerLeft(), boundary.upperRight());
    }

    public abstract Boundary getCurrentBounds();
}