package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
public class PlayerGamesTest {

    // все наши актеры
    private PlayerGames games;
    private GameType gameType;
    private PlayerScores scores;
    private Information information;
    private Game game;
    private PlayerController controller1;
    private PlayerController controller2;
    private Player player1;
    private Player player2;

    // вот их сценарий, мок на моке и моком погоняет :)
    @Before
    public void setup() {
        // given
        games = new PlayerGames();

        gameType = mock(GameType.class);
        when(gameType.name()).thenReturn("gameType");

        scores = mock(PlayerScores.class);

        information = mock(Information.class);

        game = mock(Game.class);

        controller1 = mock(PlayerController.class);
        controller2 = mock(PlayerController.class);

        player1 = new Player("player1", gameType, scores, information);
        player2 = new Player("player2", gameType, scores, information);

        // создали два игрока, играющих в одну игру
        // when
        games.add(player1, game, controller1);
        games.add(player2, game, controller2);
    }

    // дальше разные тесты на разные методы

    @Test
    public void testSize() {
        // then
        assertEquals(2, games.size());
    }

    @Test
    public void testGetByPlayerName() {
        // then
        assertPlayerGame(game, controller1, player1, games.get("player1"));
        assertPlayerGame(game, controller2, player2, games.get("player2"));
    }

    @Test
    public void testGetGameTypes() {
        // then
        List<GameType> gameTypes = games.getGameTypes();
        assertEquals(gameType, gameTypes.get(0));
        assertEquals(1, gameTypes.size());
    }

    @Test
    public void testIsEmpty() {
        // then
        assertFalse(games.isEmpty());
    }

    @Test
    public void testGetPlayers() {
        // then
        assertEquals("[player1, player2]", games.players().toString());
    }

    @Test
    public void testIterator() {
        // then
        Iterator<PlayerGame> iterator = games.iterator();
        assertPlayerGame(game, controller1, player1, iterator.next());
        assertPlayerGame(game, controller2, player2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testGetAll() {
        // then
        List<PlayerGame> gameTypes = games.getAll("gameType");
        assertPlayerGame(game, controller1, player1, gameTypes.get(0));
        assertPlayerGame(game, controller2, player2, gameTypes.get(1));
        assertEquals(2, gameTypes.size());
    }

    @Test
    public void testRemovePlayer() {
        // when
        games.remove(player1);

        // then
        assertEquals(1, games.size());

        List<PlayerGame> gameTypes = games.getAll("gameType");
        assertPlayerGame(game, controller2, player2, gameTypes.get(0));
        assertEquals(1, gameTypes.size());

        assertEquals("[player2]", games.players().toString());

        assertPlayerGame(game, controller2, player2, games.get("player2"));
    }

    @Test
    public void testClear() {
        // when
        games.clear();

        // then
        assertEquals(0, games.size());

        List<PlayerGame> gameTypes = games.getAll("gameType");
        assertEquals(0, gameTypes.size());

        assertEquals("[]", games.players().toString());
    }

    // вот тут самое интересное
    @Test
    public void testGetByPlayerName_caseNotExists() throws IOException {
        // пробуем найти несуществующего пользователя
        // в классике был бы либо throws new BlaBlaException()
        // который надо ловить - фукака
        // или return null
        // который на клиенте надо проверять постоянно - тоже накладно
        // если кто забудет - лови NPE!
        // а нам надо безопасно!!
        PlayerGame playerGame = games.get("blaBlaPlayer");

        // проверяем, что результирующий объект напичкан NullObject'ами
        // then
        assertSame(Player.NULL, playerGame.getPlayer());
        assertSame(PlayerController.NULL, playerGame.getController());
        assertSame(Game.NULL, playerGame.getGame());

        // ну и теперь симуляция клиента, разные-всякие вызовы
        // и ни одного NPE
        // и ноль изменений для системы...
        // then then
        playerGame.getController().requestControl(playerGame.getPlayer(), "board");
        playerGame.getGame().clearScore();
        playerGame.getPlayer().setName("Stiven");
        playerGame.getGame().getJoystick().down();
        playerGame.getGame().getBoardAsString();
        playerGame.getPlayer().getGameType().getSettings().getParameters().clear();
        playerGame.getPlayer().getGameType().getPlots().clone();
        playerGame.getPlayer().getGameType().getPlayerScores(12).clear();

        // вот как-то так
        // только не спеши радоваться
        // если такой объект как-то зависнет в системе -
        // его ловить потом делый квест!
        // на любителя в общем
    }

    private void assertPlayerGame(Game game, PlayerController controller, Player player1, PlayerGame playerGame) {
        assertSame(game, playerGame.getGame());
        assertSame(player1, playerGame.getPlayer());
        assertSame(controller, playerGame.getController());
    }
}
