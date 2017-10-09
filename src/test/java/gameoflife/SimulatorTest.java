package gameoflife;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimulatorTest {

    @Test
    public void givenALiveCellWithNoNeighbors_thenTheCellShouldDie() {
        //  d d d
        //  d l d
        //  l d d
        // ->
        //  d d d
        //  d d d
        //  d d d

        Board board = new Board(3);
        board.setAllCellsToDead();
        board.setCellToAlive(new Position(0, 0));
        board.setCellToAlive(new Position(1, 1));

        assertTrue(board.getCell(new Position(0, 0)).isAlive());
        assertTrue(board.getCell(new Position(1, 1)).isAlive());

        Simulator subject = new Simulator();
        Board boardAfterOneSimulation = subject.calculateNextGeneration(board);

        assertThatAllCellsAreDead(boardAfterOneSimulation);
    }

    private void assertThatAllCellsAreDead(Board board) {
        for (Cell cell : board.getCells()) {
            assertTrue(cell.isDead());
        }
    }
}