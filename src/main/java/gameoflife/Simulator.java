package gameoflife;

import com.rits.cloning.Cloner;

import java.util.Collection;
import java.util.function.Predicate;

public class Simulator {
    private GameOfLifeRulesProvider rulesProvider;

    public Simulator(GameOfLifeRulesProvider rulesProvider) {
        this.rulesProvider = rulesProvider;
    }

    public Board calculateNextGeneration(Board board) {
        Cloner cloner = new Cloner();
        Board newBoard = cloner.deepClone(board);

        for (Position position : board.getPositions()) {
            boolean isNewCellAlive = rulesProvider.calculateWhetherNewCellIsAlive(board, position);
            newBoard.getCellAt(position).setAlive(isNewCellAlive);
        }

        return newBoard;
    }
}
