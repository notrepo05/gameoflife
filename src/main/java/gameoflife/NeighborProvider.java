package gameoflife;

import java.util.Arrays;
import java.util.Collection;

class NeighborProvider {
    private Position position;

    public NeighborProvider(Position position) {
        this.position = position;
    }

    public Collection<Position> getNeighbors() {
        Position upperDiagonalRight = position.plus(new Position(1, 1));
        Position right = position.plus(new Position(1, 0));
        Position lowerDiagonalRight = position.plus(new Position(1, -1));
        Position below = position.plus(new Position(0, -1));
        Position bottomDiagonalLeft = position.plus(new Position(-1, -1));
        Position left = position.plus(new Position(-1, 0));
        Position upperDiagonalLeft = position.plus(new Position(-1, 1));
        Position above = position.plus(new Position(0, 1));
        return Arrays.asList(
                upperDiagonalRight,
                right,
                lowerDiagonalRight,
                below,
                bottomDiagonalLeft,
                left,
                upperDiagonalLeft,
                above
        );
    }
}