package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int updatesCount = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        updatesCount++;
        synchronized (System.out) {
            System.out.println("Update #" + updatesCount + ": " + message);
            System.out.println("Map ID: " + worldMap.getId());
            System.out.println(worldMap);
        }
    }
}