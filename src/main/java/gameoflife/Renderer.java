package gameoflife;

import java.io.IOException;
import java.io.OutputStream;

public class Renderer implements RendererI{
    private OutputStream outputStream;

    public Renderer (OutputStream printStream) {
        this.outputStream = printStream;
    }


    public void render(Board board)  {
        try {
        int i = 5;
        for (Position position : board.getPositions()) {
            if (i == 0) {
                outputStream.write("\n".getBytes()); i = 5;}
            try {
                renderCell(position, board.getCellAt(position));
            } catch (IOException e) {
                e.printStackTrace();
            }
            i --;
        }

            Thread.sleep(100);
            outputStream.write("\n\n\n\n\n".getBytes());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void renderCell(Position position, Cell cellAt) throws IOException {
        outputStream.write((cellAt.isAlive() ? " [ x ] " : " [ ] ").getBytes());

    }
}
