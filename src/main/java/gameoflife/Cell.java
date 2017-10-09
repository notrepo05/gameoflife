package gameoflife;

public class Cell {
    private boolean alive = false;

    public void setToAlive() {
        alive = true;
    }

    public void setToDead() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }
    public boolean isDead() {
        return !alive;
    }
}
