package com.anbo.juja.patterns.bridge_22.classic;

/**
 * Created by oleksandr.baglai on 25.02.2016.
 */
// определяет интерфейс абстракции
public abstract class Abstraction {

    // сохраняет ссылку на объект реализации абстракции -
    // мы таким образом позволили полиморфно
    // (заметь, тут Стратегия) менять поведение родителя
    // Abstraction (читай самого родителя) у наследника RefinedAbstractionC
    // что не возможно при использовании просто наследования
    private Implementor implementor;

    // как и в Стретегии мы inject'им алгоритм (реализацию абстракции)
    // через конструтктор (хотя можем и через set'тер)
    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    // и дальше используем этот алгоритм (реализацию абстракции)
    // для своих целей (целей своих наследников), делегируя ей все операции

    public void operation(char data) {
        implementor.operationImpl(data);
    }

    public abstract void operation(String data);

    public void operation(int data) {
        operation(String.valueOf(data));
    }

    public void operation(boolean data) {
        operation(String.valueOf(data));
    }

    // хитрый шаблон - мы берем цепочку наследования и заменяем
    // у одного из родителей наследование на агрегацию+делегирование, что
    // тут же позволяет использовать полиморфизм, а это в свою очередь позволяет
    // фактически заменять родителя с одного на другой во время runtime
    // (без перекомпиляции)
    // в этом суть шаблона Мост
}
