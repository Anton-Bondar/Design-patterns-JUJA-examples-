package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// игрок
public class Player {

    // он тоже может быть NULL
    // синглтончик (смотри Game.NULL - там объяснение)
    public final static Player NULL = new NullPlayer();

    private String name;
    private String gameName;
    private String password;
    private PlayerScores scores;
    private Information info;
    private GameType gameType;

    public Player(String name, GameType gameType, PlayerScores scores, Information info) {
        this.name = name;
        this.gameType = gameType;
        this.scores = scores;
        this.info = info;
    }

    // вот тут тоже интересно
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        // обрати внимание, если использовать синглтоны, то можно
        // сравнивать ссылки - у нас только один экземпляр null-объекта
        // на всю систему
        // а еще я тут позволил сравнивать игрока с другим игроком
        // и с игрой игрока, удобства ради
        if (this == Player.NULL &&
                (o != Player.NULL && o != PlayerGame.NULL)) return false;

        if (o instanceof Player) {
            Player p = (Player)o;

            return (p.name.equals(name));
        }

        if (o instanceof PlayerGame) {
            PlayerGame pg = (PlayerGame)o;

            return pg.getPlayer().equals(this);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int clearScore() {
        return scores.clear();
    }

    public int getScore() {
        return scores.getScore();
    }

    public String getMessage() {
        return info.getMessage();
    }

    public int getCurrentLevel() {
        return 0;
    }

    public String getGameName() {
        return (gameType != null)?gameType.name():gameName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
