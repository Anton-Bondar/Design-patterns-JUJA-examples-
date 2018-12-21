package com.anbo.juja.patterns.state_21.sample.musicbox;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by oleksandr.baglai on 23.02.2016.
 */
// это наш основной класс Context
public class MusicBox {

    // это нашехранилище состояний, мы их тут создадим раз
    // чтобы не создавать кажддый раз новый
    // обрати внимание как мы map наполняем ;)
    private Map<Class<? extends State>, State> states = new HashMap<Class<? extends State>, State>() {{
        put(NotEnoughMoneyState.class, new NotEnoughMoneyState(MusicBox.this));
        put(SelectMusicState.class, new SelectMusicState(MusicBox.this));
        put(PlayingMusicState.class, new PlayingMusicState(MusicBox.this));
        put(MusicNotFoundState.class, new MusicNotFoundState(MusicBox.this));
        put(HaveANiceDayState.class, new HaveANiceDayState(MusicBox.this));
    }};

    // вот тут храним состояние, которому будем все делегировать
    private State state;

    // эти поля - ответственность MusicBox
    private int account; // счет юзера
    private int cashbox; // касса общая
    private List<String> catalog;

    // конфигурируем музыкальную шкатулку каталогом песен
    public MusicBox(List<String> catalog) {
        this.catalog = catalog;
        // денег на счету нет
        account = 0;
        // состояние по-умолчанию говорит о том же
        setState(HaveANiceDayState.class);
    }

    // через этот метод состяония будут менять себя (сами!) на другие
    // метод никто вне пакета не должен видеть, потому он default-защищенный
    void setState(Class<? extends State> state) {
        this.state = states.get(state);
        this.state.showMessage();
    }

    // какой-то "стейт" может хотеть что-то делать с боксом,
    // но не напрямую сам, а через эти default методы

    boolean contains(String songName) {
        return catalog.contains(songName);
    }

    void charge(int amount) {
        account -= amount;
        if (account < 0) {
            throw new IllegalStateException("Упс, что-то пошло не так! Отрицательный счет");
        }
        cashbox += amount;
        System.out.println("Списано: " + amount + " всего на счету: " + account);
        checkIsEnough();
    }

    void checkIsEnough() {
        if (account < 30) {
            setState(NotEnoughMoneyState.class);
        } else {
            setState(SelectMusicState.class);
        }
    }

    List<String> getCatalog() {
        return new LinkedList<>(catalog);
    }

    // эти методы хотят клиенты от музыкальной шкатулки

    // забиваем музыку
    public void playMusic(String songName) {
        state.playMusic(songName);
    }

    // вставляем монетку
    public void insertCoin(int amount) {
        account += amount;
        System.out.println("Добавили: " + amount + " всего на счету: " + account);
        checkIsEnough();
    }

    // берем сдачу
    public int getChange() {
        int amount = account;
        account = 0;
        System.out.println("Сдача: " + amount + " всего на счету: " + account);
        setState(HaveANiceDayState.class);
        return amount;
    }

    // метод для дебага
    @Override
    public String toString() {
        return String.format(
                "MusicBox[account:%s, cashbox:%s, state:%s, catalog:%s]",
                account, cashbox, state.getClass().getSimpleName(), catalog
        );
    }
}
