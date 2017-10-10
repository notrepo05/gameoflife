package gameoflife;

public class GameOfLife {
    private Board board;
    private final Simulator simulator;
    private final Renderer renderer;

    public GameOfLife(Board board, Simulator simulator, Renderer renderer) {
        this.board = board;
        this.simulator = simulator;
        this.renderer = renderer;
    }

    public void run(int count) {
        for (int i = 0; i < count; i++){
            this.board = simulator.calculateNextGeneration(board);
            renderer.render(board);
        }
    }
}
