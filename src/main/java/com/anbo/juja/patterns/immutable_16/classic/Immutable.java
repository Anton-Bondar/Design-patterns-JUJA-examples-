package com.anbo.juja.patterns.immutable_16.classic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleksandr.baglai on 21.12.2015.
 */
// неизменяемый объект
// final класс, чтобы нельзя было занаследоваться и
// получить доступ к полям из наследника
public final class Immutable {

    // инкапсулируемые данные
    // обязательно private, чтобы доступа извне небыло
    // и final, чтобы случайно ен заменить внутри этого класса
    private final List<String> data;

    // конструктор с установкой поля
    // копирует данные передаваемые извне
    public Immutable(List<String> data) {
        this.data = new ArrayList<>(data);
    }

    // копирующий конструктор, если он есть,
    // должен копировать все перед установкой
    public Immutable(Immutable input) {
        this.data = new ArrayList<>(input.data);
    }

    // кроме того ссылка this не должна пропасть во время конструирования

    // геттеры, если они есть, отдают копию
    public List<String> getData() {
        return new ArrayList<>(data);
    }

    // сеттеров нет, только через конструктор
    // public void setData(List<String> data) {
    //     this.data = data
    // }

    @Override
    public String toString() {
        return data.toString();
    }

    // больше нет никаких методов для имзенения состояния
    // а все методы чтения - выдают копии
    // чтобы клиент не смог изменить это имея на руках ссылку
}
