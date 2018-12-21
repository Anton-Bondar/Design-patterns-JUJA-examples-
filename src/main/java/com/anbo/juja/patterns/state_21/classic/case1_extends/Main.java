package com.anbo.juja.patterns.state_21.classic.case1_extends;

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
        // Set state: A
        // Handled by A: data1
        // Set state: B
        // Handled by B: data2
        // Set state: C
        // Handled by C: data3
        // Set state: A
        // Handled by A: data4
        // Set state: B
        // Handled by B: data5
        // Set state: C
    }
}
