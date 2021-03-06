package com.anbo.juja.patterns.сhain_of_responsibility_07.sample.juja;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
public class Main {

    public static void main(String[] args) {
        JuJaTeam juja = new JuJaTeam();

        juja.process("А что это за фигня у вас?");
        juja.process("А можно купить шаблоны?");
        juja.process("У меня есть идея, по новому продукту - вот смотрите: ...");
        juja.process("Там у вас ошибка с lms - вот смотрите: ...");
        juja.process("Там у вас сайт упал, ошибка какая-то...");
        juja.process("Там ошибка. У вас глючит что-то, вот смотрите: ...");
        juja.process("Вот вам 150$ хочу juja core...");
        juja.process("Хочу juja core, вот вам 1$");
        juja.process("Хочу juja core, вот вам 10$");
        juja.process("Вот вам 50$ хочу juja core...");
        juja.process("Вот вам 50$ хочу design patterns...");
        juja.process("Вот вам 200$ хочу индивидуальную консультацию...");

        // Вывод
        // ----------------------------------------
        // Q: А что это за фигня у вас?
        // A: Как вас зовут?
        //
        // A: Давай досвидания...
        // ----------------------------------------
        // Q: А можно купить шаблоны?
        // A: Как вас зовут?
        // Стивен
        // A: Да, вот линк на платежку http://juja.com.ua/...
        // ----------------------------------------
        // Q: У меня есть идея, по новому продукту - вот смотрите: ...
        // A: Как вас зовут?
        // Стивен
        // A: Мы попробуем что-то сделать...
        // V: Классная идея! Ребята попробуем?..
        // D: Дайте мне пару дней...
        // C: Давай пробовать!
        // ----------------------------------------
        // Q: Там у вас ошибка с lms - вот смотрите: ...
        // A: Как вас зовут?
        // Стивен
        // A: Мы попробуем что-то сделать...
        // D: Минутку...
        // D: LMS исправил!
        // ----------------------------------------
        // Q: Там у вас сайт упал, ошибка какая-то...
        // A: Как вас зовут?
        // Стивен
        // A: Мы попробуем что-то сделать...
        // D: Минутку...
        // D: Сайт поднял!
        // ----------------------------------------
        // Q: Там ошибка. У вас глючит что-то, вот смотрите: ...
        // A: Как вас зовут?
        // Стивен
        // A: Мы попробуем что-то сделать...
        // D: Минутку...
        // D: Все пофикшено!
        // ----------------------------------------
        // Q: Вот вам 150$ хочу juja core...
        // A: Как вас зовут?
        // Стивен
        // A: На вас счет зачислено: 150$
        // V: Вы приняты на курс juja core!
        // C: Давай учиться!
        // ----------------------------------------
        // Q: Хочу juja core, вот вам 1$
        // A: Как вас зовут?
        // ХХХ
        // A: Что-то пошло не так, повторите отправку. Минимальная сумма - 50$
        // 1
        // A: Что-то пошло не так, повторите отправку. Минимальная сумма - 50$
        // 0
        // A: Давай досвидания...
        // ----------------------------------------
        // Q: Хочу juja core, вот вам 10$
        // A: Как вас зовут?
        // Стивен
        // A: Что-то пошло не так, повторите отправку. Минимальная сумма - 50$
        // 49
        // A: Что-то пошло не так, повторите отправку. Минимальная сумма - 50$
        // 50
        // A: На вас счет зачислено: 50$
        // V: Вы приняты на курс juja core!
        // V: Сумма долга составляет: 100$
        // C: Давай учиться!
        // ----------------------------------------
        // Q: Вот вам 50$ хочу juja core...
        // A: Как вас зовут?
        // Стивен
        // A: На вас счет зачислено: 50$
        // V: Вы приняты на курс juja core!
        // V: Сумма долга составляет: 100$
        // C: Давай учиться!
        // ----------------------------------------
        // Q: Вот вам 50$ хочу design patterns...
        // A: Как вас зовут?
        // Стивен
        // A: На вас счет зачислено: 50$
        // V: Вы приняты на курс design patterns!
        // C: Давай учиться!
        // ----------------------------------------
        // Q: Вот вам 200$ хочу индивидуальную консультацию...
        // A: Как вас зовут?
        // Стивен
        // A: На вас счет зачислено: 200$
        // V: Ребята, тут интересное предложение!
        // D: Дайте мне пару дней...
        // C: Давай пробовать!
    }
}