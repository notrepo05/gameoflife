package gameoflife;

import javafx.geometry.Pos;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;


// hacked together without TDD because I'm impatient and it's late
public class Renderer {
    private PrintStream printStream;

    public Renderer (PrintStream printStream) {
        this.printStream = printStream;
    }


    public void render(Board board) {
        int i = 5;
        for (Position position : board.getPositions()) {
            if (i == 0) {printStream.println(); i = 5;}
            renderCell(position, board.getCellAt(position));
            i --;
        }
        try {
            Thread.sleep(100);
            printStream.print("\n\n\n\n\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void renderCell(Position position, Cell cellAt) {
        printStream.print((cellAt.isAlive() ? " [ x ] " : " [ ] "));

    }
}
