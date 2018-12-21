package com.anbo.juja.patterns.builder_20.classic.case0_classic;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// абстракция определяет шаги которые предстоит совершить,
// чтобы собрать структуру (один объект или композит из нескольких)
public abstract class Builder {

    // тут будет храниться собираемый продукт
    // заметь он protected - чтобы из наследника было доступным
    protected Product product;

    // метод для инстанциирования продукта (самый первый этап)
    public void buildPart1(){
        product = new Product();
    }

    // метод для получения результатов
    public Product getResult(){
        return product;
    }

    // а это другие этапы
    protected abstract void buildPart2();
    protected abstract void buildPart3();
    protected abstract void buildPart4();
}

