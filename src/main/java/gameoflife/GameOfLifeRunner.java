package gameoflife;

public class GameOfLifeRunner {
    public static void main(String[] args) {
        Board board = new Board(5);
//        board.setCellToAlive(Position.at(1, 0));
        board.setCellToAlive(Position.at(2, 2));
        board.setCellToAlive(Position.at(3, 2));
        board.setCellToAlive(Position.at(4, 2));

        GameOfLife gameOfLife = new GameOfLife(board, new Simulator(new GameOfLifeRulesProvider()), new Renderer(System.out));
        gameOfLife.run(10);
    }
}
