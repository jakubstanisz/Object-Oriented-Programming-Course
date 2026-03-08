package agh.ics.oop;

import agh.ics.oop.model.*;
import java.util.ArrayList;
import java.util.List;



public class Simulation implements Runnable {
    private final List<Animal> animals = new ArrayList<>();
    private final List<MoveDirection> moves;
    private final WorldMap map;

    public Simulation(List<Vector2d> startPositions, List<MoveDirection> moves, WorldMap map) {
        this.moves = moves;
        this.map = map;
        for (Vector2d position : startPositions) {
            Animal animal = new Animal(position);
            try {
                map.place(animal);
                animals.add(animal);
            } catch (IncorrectPositionException e) {
                System.out.println("Warning: " + e.getMessage());
            }
        }
    }

    @Override
    public void run() {
        int n = animals.size();
        if (n == 0) return;

        for (int i = 0; i < moves.size(); i++) {
            Animal animal = animals.get(i % n);
            map.move(animal, moves.get(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}