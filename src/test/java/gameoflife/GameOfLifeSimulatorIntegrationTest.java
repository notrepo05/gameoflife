package gameoflife;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class GameOfLifeSimulatorIntegrationTest {

    @Test
    public void givenAPeriod2Blinker_whenFourGenerationHaveElapsed_thenTheBoardShouldRenderTheCorrectBlinkerState() throws IOException {
        String blinkResult = "" +
                " [ ]  [ ]  [ ]  [ ]  [ ] \n" +
                " [ ]  [ ]  [ ]  [ ]  [ ] \n" +
                " [ ]  [ x ]  [ x ]  [ x ]  [ ] \n" +
                " [ ]  [ ]  [ ]  [ ]  [ ] \n" +
                " [ ]  [ ]  [ ]  [ ]  [ ] \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                " [ ]  [ ]  [ ]  [ ]  [ ] \n" +
                " [ ]  [ ]  [ x ]  [ ]  [ ] \n" +
                " [ ]  [ ]  [ x ]  [ ]  [ ] \n" +
                " [ ]  [ ]  [ x ]  [ ]  [ ] \n" +
                " [ ]  [ ]  [ ]  [ ]  [ ] \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n";

        String blinkResultAfterFourGenerations = blinkResult.concat(blinkResult);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        Board period2Blinker = new Board(5);
        period2Blinker.setCellToAlive(Position.at(1, 2));
        period2Blinker.setCellToAlive(Position.at(2, 2));
        period2Blinker.setCellToAlive(Position.at(3, 2));

        Renderer renderer = new Renderer(outputStream);
        GameOfLife subject = new GameOfLife(period2Blinker, new Simulator(new GameOfLifeRulesProvider()), renderer);

        subject.run(4);

        assertThat(blinkResultAfterFourGenerations).isEqualTo(outputStream.toString());
    }
}