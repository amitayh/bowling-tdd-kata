package katas.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void testGutterGame() {
        rollMany(20, 0);

        assertEquals(0, game.score());
    }

    @Test
    void testAllOnes() {
        rollMany(20, 1);

        assertEquals(20, game.score());
    }

    @Test
    void testOneSpare() {
        game.roll(5);
        game.roll(5); // Spare
        game.roll(3);
        rollMany(17, 0);

        assertEquals(16, game.score());
    }

    @Test
    void testOneStrike() {
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);

        assertEquals(24, game.score());
    }

    @Test
    void testPerfectGame() {
        rollMany(12, 10);

        assertEquals(300, game.score());
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }

}
