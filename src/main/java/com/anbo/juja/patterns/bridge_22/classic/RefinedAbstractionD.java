package com.anbo.juja.patterns.bridge_22.classic;

/**
 * Created by oleksandr.baglai on 25.02.2016.
 */
// уточнение абстракции - расшиярет/уточняет интерфейс, задаваемый абстракцией Abstraction
public class RefinedAbstractionD extends Abstraction {

    public RefinedAbstractionD(Implementor implementor) {
        super(implementor);
    }

    // единственное отличие этой уточненной абстракции - печатаем задом-наперед
    @Override
    public void operation(String data) {
        for (int index = data.length() - 1; index >= 0; index--) {
            operation(data.charAt(index));
        }
    }
}
