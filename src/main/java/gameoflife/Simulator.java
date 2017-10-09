package gameoflife;

public class Simulator {
    private Board board;
    public Board calculateNextGeneration(Board board) {
        board.setAllCellsToDead();
        return board;
    }
}
