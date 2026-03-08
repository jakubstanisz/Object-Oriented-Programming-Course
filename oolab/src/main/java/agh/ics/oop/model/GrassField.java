package agh.ics.oop.model;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int grassCount) {
        Random random = new Random();
        int range = (int) Math.sqrt(grassCount * 10);
        int i = 0;
        while (i < grassCount) {
            Vector2d pos = new Vector2d(random.nextInt(range + 1), random.nextInt(range + 1));
            if (!grasses.containsKey(pos)) {
                grasses.put(pos, new Grass(pos));
                i++;
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object object = super.objectAt(position);
        return !(object instanceof Animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grasses.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement animal = super.objectAt(position);
        if (animal != null) {
            return animal;
        }
        return grasses.get(position);
    }

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = super.getElements();
        elements.addAll(grasses.values());
        return elements;
    }

    @Override
    public Boundary getCurrentBounds() {
        List<WorldElement> elements = getElements();
        if (elements.isEmpty()) {
            return new Boundary(new Vector2d(0, 0), new Vector2d(0, 0));
        }

        Vector2d lowerLeft = elements.get(0).getPosition();
        Vector2d upperRight = elements.get(0).getPosition();

        for (WorldElement element : elements) {
            lowerLeft = lowerLeft.lowerLeft(element.getPosition());
            upperRight = upperRight.upperRight(element.getPosition());
        }

        return new Boundary(lowerLeft, upperRight);
    }
}