import gameoflife.Board;
import gameoflife.GameOfLife;
import gameoflife.Renderer;
import gameoflife.Simulator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameOfLifeTest {
    @Mock
    private Board board;

    @Mock
    private Simulator simulator;

    @Mock
    private Renderer renderer;

    private GameOfLife subject;

    @Before
    public void setup() {
        subject = new GameOfLife(board, simulator, renderer);
    }

    @Test
    public void when_GameOfLifeIsRanWithOneGen_thenOneGenerationIsSimulated() throws IOException {
        subject.run(1);

        verify(simulator).calculateNextGeneration(board);
        verify(renderer).render(board);
    }

    @Test
    public void when_GameOfLifeIsRanManyTimes_thenMAnyGenerationsAreSimulated() throws IOException {
        subject.run(3);

        verify(simulator, times(3)).calculateNextGeneration(any(Board.class));
        verify(renderer, times(3)).render(any(Board.class));
    }
}