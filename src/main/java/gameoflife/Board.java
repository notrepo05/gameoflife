package gameoflife;

import java.util.*;

public class Board {
    private Map<Position, Cell> cells;

    public int getDimensionality() {
        return dimensionality;
    }

    private int dimensionality;

    public Board(int dimensionality) {
        cells = new HashMap<>();
        this.dimensionality = dimensionality;
        initializeBoardWithCells(dimensionality);
    }

    private void initializeBoardWithCells(int dimensionality) {
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

    public Cell getCellAt(Position position) {
        return cells.get(position);
    }

    public Collection<Cell> getCells() {
        return Arrays.asList(new Cell());
    }

    public void setCellToDead(Position position) {
        cells.get(position).setToDead();
    }

    public Set<Position> getPositions() {
        return cells.keySet();
    }

    public Collection<Position> getNeighborsOf(Position position) {
        return new NeighborProvider(position).getNeighbors();
    }
}
