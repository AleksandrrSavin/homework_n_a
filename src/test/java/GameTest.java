import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTest {
    Player player1 = new Player(1, "John", 10);
    Player player2 = new Player(2, "Alex", 9);
    Player player3 = new Player(3, "Alex", 12);
    Player player4 = new Player(4, "Nick", 0);
    Player player5 = new Player(5, "Jax", 9);
    Player player6 = new Player(6, "Kim", 10);

    private Game fillPlayers() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        return game;
    }

    @Test
    public void shouldRegister() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        List<Player> actual = Arrays.asList(player1, player2);
        List<Player> expected = game.findAllPlayers();

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void shouldFindByName() {
        Game game = fillPlayers();
        Player actual = game.findByName("John");
        Player expected = player1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindName() {
        Game game = fillPlayers();
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.findByName("Arnold");
        });
    }


    @Test
    public void shouldFindReturn0AfterRound() {
        Game game = fillPlayers();
        int actual = game.round("Alex", "Jax");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindReturn1AfterRound() {
        Game game = fillPlayers();
        int actual = game.round("John", "Jax");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindReturnMinus1AfterRound() {
        Game game = fillPlayers();
        int actual = game.round("Nick", "Jax");
        int expected = -1;

        Assertions.assertEquals(expected, actual);
    }
}
