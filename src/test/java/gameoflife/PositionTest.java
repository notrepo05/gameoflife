package gameoflife;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PositionTest {
    @Test
    public void givenTwoPositionsWithEqualCoordinates_thenTheyShouldEqual() {
        Position position1 = new Position(0, 0);
        Position position2 = new Position(0, 0);
        assertThat(position1).isEqualTo(position2);
    }

}