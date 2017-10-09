package gameoflife;

import java.util.Collection;
import java.util.function.Predicate;

public class GameOfLifeRulesProvider {
    public boolean calculateWhetherNewCellIsAlive(Board board, Position position) {
        if(exactlyThreeNeighborsAreAlive(board, position)) {
            return true;
        }
        if (hasFewerThanTwoLiveNeighbors(board, position)) {
            return false;
        }
        if (hasMoreThanTwoLiveNeighbors(board, position)) {
            return false;
        }
        return board.getCellAt(position).isAlive();
    }

    private boolean hasMoreThanTwoLiveNeighbors(Board board, Position position) {
        return compareAliveNeighborCountWith(board, position, (neighborCount) -> {return neighborCount > 3;});
    }

    private boolean hasFewerThanTwoLiveNeighbors(Board board, Position position) {
        return compareAliveNeighborCountWith(board, position, (neighborCount) -> {return neighborCount < 2;});
    }

    private boolean exactlyThreeNeighborsAreAlive(Board board, Position position) {
        return compareAliveNeighborCountWith(board, position, (neighborCount) -> {return neighborCount == 3;});
    }

    private boolean compareAliveNeighborCountWith(Board board, Position position, Predicate<Integer> predicate) {
        Collection<Position> neighbors = board.getNeighborsOf(position);

        int aliveNeighborCount = 0;
        for (Position neighborPosition : neighbors) {
            if (neighborIsAlive(board, neighborPosition)) {
                aliveNeighborCount++;
            }
        }
        return predicate.test(aliveNeighborCount);
    }

    private boolean neighborIsAlive(Board board, Position neighborPosition) {
        return cellExists(board, neighborPosition) && board.getCellAt(neighborPosition).isAlive();
    }

    private boolean cellExists(Board board, Position neighborPosition) {
        return board.getCellAt(neighborPosition) != null;
    }
}
