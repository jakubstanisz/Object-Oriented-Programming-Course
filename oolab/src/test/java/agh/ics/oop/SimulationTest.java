package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void testSimulation() {
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        RectangularMap map = new RectangularMap(5, 5);

        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();

        Animal animal1 = (Animal) map.objectAt(new Vector2d(2, 0));
        assertNotNull(animal1);
        assertEquals(MapDirection.SOUTH, animal1.getOrientation());

        Animal animal2 = (Animal) map.objectAt(new Vector2d(3, 4));
        assertNotNull(animal2);
        assertEquals(MapDirection.NORTH, animal2.getOrientation());
    }
}