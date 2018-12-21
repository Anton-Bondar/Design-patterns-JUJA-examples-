package com.anbo.juja.patterns.immutable_16.classic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleksandr.baglai on 21.12.2015.
 */
// изменяемый объект
public class Mutable {

    // лазейка - можно занаследоваться и влиять на поле
    protected List<String> data;

    // лазейка - можно передать "свой" List и менять потом его,
    // меняя при этом содержимое объекта
    public Mutable(List<String> data) {
        this.data = data;
    }

    // лазейка в копирующем конструкторе -
    // теперь два объекта будут содержать ссылку на
    // один и тот же список
    public Mutable(Mutable input) {
        this.data = input.data;
    }

    // лазейка - геттер отдал оригинальный список
    // в чем же тогда инкапсуляция? такой список легко
    // изменить за пределами объекта
    // mutable.getData().clear()
    // и никому ничего за это не будет
    public List<String> getData() {
        return data;
    }

    // лазейка - сеттер ставит в поле сразу значение
    // клиент может потом оставить себе ссылочку
    // и менять "под шумок"
    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    // и другие методы, которые как-то нарушают инкапсуляцию
    // или меняют состояние объекта
}
