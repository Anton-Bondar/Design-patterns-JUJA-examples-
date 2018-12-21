package com.anbo.juja.patterns.facade_17.sample.score;

/**
 * Created by oleksandr.baglai on 28.12.2015.
 */
public class Main {
    public static void main(String[] args) {
        // берем json'чик
        // оборачиваем в ScoreReader
        ScoreReader reader = new ScoreReaderWithFacade(
                "{'logs':[" +
                        "{'name':'stiven',score:14}," +
                        "{'name':'eva',score:17}," +
                        "{'name':'stiven',score:45}," +
                        "{'name':'eva',score:24}," +
                        "{'name':'eva',score:52}," +
                        "{'name':'bob',score:24}," +
                        "{'name':'bob',score:73}," +
                        "{'name':'bob',score:14}," +
                        "{'name':'eva',score:67}," +
                        "{'name':'stiven',score:35}," +
                        "{'name':'eva',score:84}," +
                        "{'name':'stiven',score:24}," +
                "]}");

        // и достаем все что надо
        for (String user : reader.getUsers()) {
            int score = reader.getTotalScore(user);
            System.out.println(user + ":" + score);
        }
        System.out.println("TOTAL:" + reader.getTotalScore());

        // вывод
        // stiven:118
        // bob:111
        // eva:244
        // TOTAL:473
    }
}
