package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case2;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
// все тот же специализаирующийся по Boolean обработчик
public class ConcreteHandlerA extends Handler {

    @Override
    protected boolean handle(Request request){
        // обрати внимание на этот флаг, который вернется из метода
        boolean canProcess = request.getMessage() instanceof Boolean;
        if (canProcess) {
            // если обработали
            System.out.printf("Request %s processed by ConcreteHandlerA\n", request);
        }
        // сигнализируем об этом, и родитель решит что сигнал передавать дальше не стоит
        return canProcess;
    }
}