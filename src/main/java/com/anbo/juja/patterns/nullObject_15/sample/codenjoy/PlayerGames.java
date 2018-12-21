package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// а это контейнер всех игор и связанных с ними игроков
public class PlayerGames implements Iterable<PlayerGame> {

    // тут храним
    private List<PlayerGame> playerGames = new LinkedList<PlayerGame>();

    // дальше CRUD

    public void remove(Player player) {
        int index = playerGames.indexOf(player);
        if (index == -1) return;
        playerGames.remove(index).remove();
    }

    public PlayerGame get(String playerName) {
        for (PlayerGame playerGame : playerGames) {
            if (playerGame.getPlayer().getName().equals(playerName)) {
                return playerGame;
            }
        }
        // самое интересное место тут!
        // если мы не нашли игрока, то вернем не null
        // а null object, который на все геттеры возвращающие объекты
        // вернет тоже null object'ы и так до примитивов
        // такое себе деревцо null object'ов
        // загляни вовнутрь...
        return PlayerGame.NULL;
    }

    public void add(Player player, Game game, PlayerController controller) {
        Joystick joystick = Joystick.NULL;
        controller.registerPlayerTransport(player, joystick);
        playerGames.add(new PlayerGame(player, game, controller, joystick));
    }

    public boolean isEmpty() {
        return playerGames.isEmpty();
    }

    @Override
    public Iterator<PlayerGame> iterator() {
        return playerGames.iterator();
    }

    public List<Player> players() {
        List<Player> result = new ArrayList<Player>(playerGames.size());

        for (PlayerGame playerGame : playerGames) {
            result.add(playerGame.getPlayer());
        }

        return result;
    }

    public int size() {
        return playerGames.size();
    }

    public void clear() {
        for (PlayerGame playerGame : playerGames) {
            playerGame.remove();
        }
        playerGames.clear();
    }

    public List<PlayerGame> getAll(String gameType) {
        List<PlayerGame> result = new LinkedList<PlayerGame>();

        for (PlayerGame playerGame : playerGames) {
            if (playerGame.getPlayer().getGameName().equals(gameType)) {
                result.add(playerGame);
            }
        }

        return result;
    }

    public List<GameType> getGameTypes() {
        List<GameType> result = new LinkedList<GameType>();

        for (PlayerGame playerGame : playerGames) {
            GameType gameType = playerGame.getPlayer().getGameType();
            if (!result.contains(gameType)) {
                result.add(gameType);
            }
        }

        return result;
    }
}
