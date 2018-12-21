package com.anbo.juja.patterns.сhain_of_responsibility_07.sample.juja;

/**
 * Created by oleksandr.baglai on 01.10.2015.
 */
public class JuJaTeam {

    // наша команда
    private TeamMember alex = new AleksandrBaglai();
    private TeamMember viktor = new ViktorKuchin();
    private TeamMember alena = new AlenaKuznetsova();
    private TeamMember danil = new DanilKuznetsov();

    public JuJaTeam() {
        // очередь сообщений
        alena.next(viktor).next(danil).next(alex);
    }

    public void process(String request) {
        // все удары принимает Алена
        alena.handleRequest(new Request(request));
    }
}
