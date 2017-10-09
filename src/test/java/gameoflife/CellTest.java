package gameoflife;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {
    @Test
    public void givenAFreshCell_thenItShouldBeDead() {
        assertTrue(new Cell().isDead());
        assertFalse(new Cell().isAlive());
    }

    @Test
    public void givenADeadCell_whenItIsSetToAlive_thenItShouldBeAlive() {
        Cell subject = new Cell();
        subject.setToAlive();
        assertTrue(subject.isAlive());
        assertFalse(subject.isDead());
    }

    @Test
    public void givenAnAliveCell_whenItIsSetToDead_thenItShouldBeDead() {
        Cell subject = new Cell();
        subject.setToDead();
        assertTrue(subject.isDead());
        assertFalse(subject.isAlive());
    }
}