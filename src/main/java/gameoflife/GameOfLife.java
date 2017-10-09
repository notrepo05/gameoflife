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
        // board = dis render aint tdd'd out redo this
        renderer.render(board);

        for (int i = 0; i < count; i++){
            // board = simulator.calc.. is not ttd'd out. redo this!
            this.board = simulator.calculateNextGeneration(board);
            renderer.render(board);
        }
    }
}
