package gameoflife;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void givenABoard_whenInitialized_thenItsCellsShouldAllBeDead() {
        Board subject = new Board(1);
        assertTrue(subject.getCell(new Position(0, 0)).isDead());
        assertFalse(subject.getCell(new Position(0, 0)).isAlive());
    }
}