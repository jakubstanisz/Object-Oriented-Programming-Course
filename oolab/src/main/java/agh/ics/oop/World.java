package agh.ics.oop;

import agh.ics.oop.model.*;
import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartowal");

        try {
            List<MoveDirection> directions = OptionsParser.parse(args);
            List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

            List<Simulation> simulations = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                AbstractWorldMap map = new GrassField(10);
                map.addObserver(new ConsoleMapDisplay());
                simulations.add(new Simulation(positions, directions, map));
            }

            SimulationEngine engine = new SimulationEngine(simulations);
            engine.runAsyncInThreadPool();

            engine.awaitSimulationsEnd();

        } catch (IllegalArgumentException | InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("System zakonczyl dzialanie");
    }
}