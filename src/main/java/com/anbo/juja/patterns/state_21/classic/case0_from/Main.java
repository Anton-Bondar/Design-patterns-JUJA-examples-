package com.anbo.juja.patterns.state_21.classic.case0_from;

/**
 * Created by oleksandr.baglai on 22.02.2016.
 */
// Класс - запускатор
public class Main {

    public static void main(String[] args) {
        // все просто, создаем компонент
        Context context = new Context();

        // делаем вызовы полезной логики
        // стейты будут семи себя заменять
        context.request("data1");
        context.request("data2");
        context.request("data3");
        context.request("data4");
        context.request("data5");

        // вывод:
        // Set state: ConcreteStateA
        // Handled by ConcreteStateA:data1
        // Set state: ConcreteStateB
        // Handled by ConcreteStateB:data2
        // Set state: ConcreteStateC
        // Handled by ConcreteStateC:data3
        // Set state: ConcreteStateA
        // Handled by ConcreteStateA:data4
        // Set state: ConcreteStateB
        // Handled by ConcreteStateB:data5
        // Set state: ConcreteStateC
    }
}
