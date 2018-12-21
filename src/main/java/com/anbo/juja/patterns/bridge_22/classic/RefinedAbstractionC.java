package com.anbo.juja.patterns.bridge_22.classic;

/**
 * Created by oleksandr.baglai on 25.02.2016.
 */
// уточнение абстракции - расшиярет/уточняет интерфейс, задаваемый абстракцией Abstraction
public class RefinedAbstractionC extends Abstraction {

    public RefinedAbstractionC(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation(String data) {
        for (int index = 0; index < data.length(); index++) {
            operation(data.charAt(index));
        }
    }
}
