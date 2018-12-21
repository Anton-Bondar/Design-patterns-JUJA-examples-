package com.anbo.juja.patterns.сhain_of_responsibility_07.sample.juja;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
// это я :)
public class AleksandrBaglai extends TeamMember {

    @Override
    protected boolean canHandle(Request request) {
        // отвечаю в основном за обучение
        return request.getType() == Request.Type.TRAINEE ||
                // а еще мне нравятся идеи
                request.getType() == Request.Type.NEW_IDEA;
    }

    @Override
    protected boolean handle(Request request){
        if (request.getType() == Request.Type.TRAINEE) {
            System.out.println("C: Давай учиться!");
        } else {
            System.out.println("C: Давай пробовать!");
        }
        return true;
    }

}