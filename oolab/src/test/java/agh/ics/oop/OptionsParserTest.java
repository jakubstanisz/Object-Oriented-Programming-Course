package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void shouldParseValidDirections() {
        String[] input = {"f", "b", "r", "l"};
        List<MoveDirection> result = OptionsParser.parse(input);
        List<MoveDirection> expected = List.of(
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT
        );
        assertEquals(expected, result);
    }

    @Test
    void shouldThrowOnInvalidInput() {
        String[] input = {"f", "x", "b"};
        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(input));
    }
}