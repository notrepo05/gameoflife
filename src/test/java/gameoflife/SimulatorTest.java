package gameoflife;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimulatorTest {

    @Test
    public void givenADeadBoard_whenNextGenSimulated_thenAllCellsShouldRemainDead() {
        Board board = new Board(3);

        Simulator simulator = new Simulator(new GameOfLifeRulesProvider());
        simulator.calculateNextGeneration(board);

        assertThatAllCellsAreDead(board);
    }

    @Test
    public void givenALiveCellWithNoNeighbors_whenNextGenSimulated_thenTheCellShouldDie() {
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


        assertTrue(board.getCellAt(new Position(0, 0)).isAlive());
        assertTrue(board.getCellAt(new Position(1, 1)).isAlive());

        Simulator subject = new Simulator(new GameOfLifeRulesProvider());
        Board boardAfterOneSimulation = subject.calculateNextGeneration(board);

        assertThatAllCellsAreDead(boardAfterOneSimulation);
    }

    @Test
    public void givenABoardWithAnAliveCellWithTwoAliveNeighbors_thenTheCellShouldRemainAlive() {
        Board board = new Board(3);
        // d l l
        // d l d
        // d d d
        // ->
        // d l l
        // d l d
        // d d d

        board.setCellToAlive(Position.at(1, 1));
        board.setCellToAlive(Position.at(1, 2));
        board.setCellToAlive(Position.at(2, 2));

        Simulator subject = new Simulator(new GameOfLifeRulesProvider());
        Board boardAfterOneSimulation = subject.calculateNextGeneration(board);

        assertTrue(boardAfterOneSimulation.getCellAt(Position.at(1, 1)).isAlive());
        assertTrue(boardAfterOneSimulation.getCellAt(Position.at(1, 2)).isAlive());
        assertTrue(boardAfterOneSimulation.getCellAt(Position.at(2, 2)).isAlive());
    }

    @Test
    public void givenABoardWithADeadCellWithThreeLivingNeighbors_thenTheCellShouldBecomeLiving() {
        Board board = new Board(3);
        board.setCellToAlive(Position.at(0, 0));
        board.setCellToAlive(Position.at(0, 1));
        board.setCellToAlive(Position.at(2, 2));
        board.setCellToDead(Position.at(1, 1));

        assertTrue(board.getCellAt(Position.at(1, 1)).isDead());

        Simulator simulator = new Simulator(new GameOfLifeRulesProvider());
        Board boardAfterOneGeneration = simulator.calculateNextGeneration(board);

        assertTrue(boardAfterOneGeneration.getCellAt(Position.at(1, 1)).isAlive());
    }

    @Test
    public void givenABoardWithAnAliveCellWithTwoAliveNeighbors_thenTheCellShouldNotDie() {
        Board board = new Board(3);
        board.setCellToAlive(Position.at(2, 2));
        board.setCellToAlive(Position.at(1, 2));
        board.setCellToAlive(Position.at(1, 1));

        Simulator simulator = new Simulator(new GameOfLifeRulesProvider());
        Board boardAfterOneGeneration = simulator.calculateNextGeneration(board);

        assertTrue(boardAfterOneGeneration.getCellAt(Position.at(1, 1)).isAlive());
    }

    @Test
    public void givenABoardWithAnAliveCellWithOnlyOneAliveNeighbor_thenTheCellShouldDie() {
        Board board = new Board(3);
        board.setCellToAlive(Position.at(2, 2));
        board.setCellToAlive(Position.at(1, 1));

        Simulator simulator = new Simulator(new GameOfLifeRulesProvider());
        Board boardAfterOneGeneration = simulator.calculateNextGeneration(board);

        assertTrue(boardAfterOneGeneration.getCellAt(Position.at(1, 1)).isDead());
    }

    @Test
    public void givenABoardWithACellWithOneLivingNeighbor_thenTheCellShouldDie() {
        Board board = new Board(3);
        board.setCellToAlive(Position.at(2, 2));
        board.setCellToAlive(Position.at(1, 1));

        Simulator simulator = new Simulator(new GameOfLifeRulesProvider());
        Board boardAfterOneGeneration = simulator.calculateNextGeneration(board);

        assertTrue(boardAfterOneGeneration.getCellAt(Position.at(1, 1)).isDead());
    }

    @Test
    public void givenABoardWithAnAliveCellWithThreeAliveNeighbors_thenTheCellShouldNotDie() {
        Board board = new Board(3);
        board.setCellToAlive(Position.at(2, 2));
        board.setCellToAlive(Position.at(1, 2));
        board.setCellToAlive(Position.at(2, 1));
        board.setCellToAlive(Position.at(1, 1));

        Simulator simulator = new Simulator(new GameOfLifeRulesProvider());
        Board boardAfterOneGeneration = simulator.calculateNextGeneration(board);

        assertTrue(boardAfterOneGeneration.getCellAt(Position.at(1, 1)).isAlive());
    }

    @Test
    public void givenABoardWithAnAliveCellWithMoreThanThreeAliveNeighbors_thenTheCellShouldDie() {
        Board board = new Board(3);
        board.setCellToAlive(Position.at(2, 2));
        board.setCellToAlive(Position.at(1, 2));
        board.setCellToAlive(Position.at(2, 1));
        board.setCellToAlive(Position.at(0, 1));
        board.setCellToAlive(Position.at(1, 1));

        Simulator simulator = new Simulator(new GameOfLifeRulesProvider());
        Board boardAfterOneGeneration = simulator.calculateNextGeneration(board);

        assertTrue(boardAfterOneGeneration.getCellAt(Position.at(1, 1)).isDead());
    }

    private void assertThatAllCellsAreDead(Board board) {
        for (Cell cell : board.getCells()) {
            assertTrue(cell.isDead());
        }
    }
}