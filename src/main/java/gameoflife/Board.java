package gameoflife;

import java.util.*;

public class Board {
    private Map<Position, Cell> cells;

    public Board(int dimensionality) {
        cells = new HashMap<>();

        for (int i = 0; i < dimensionality; i++) {
            for (int j = 0; j < dimensionality; j++) {
                cells.put(new Position(i, j), new Cell());
            }
        }
    }

    public Cell setCell(int i, int i1) {
        return null;
    }

    public void setAllCellsToDead() {
    }

    public void setCellToAlive(Position position) {
        cells.get(position).setToAlive();
    }

    public Cell getCell(Position position) {
        return cells.get(position);
    }

    public Collection<Cell> getCells() {
        return Arrays.asList(new Cell());
    }
}
