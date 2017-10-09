package gameoflife;

import javafx.geometry.Pos;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = {"x", "y"})
public class Position {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position(int x , int y) {
        this.x = x;
        this.y = y;
    }

    public static Position at(int x, int y) {
        return new Position(x, y);
    }

    public Position plus(Position position) {
        return Position.at(x + position.getX(), y + position.getY());
    }
}
