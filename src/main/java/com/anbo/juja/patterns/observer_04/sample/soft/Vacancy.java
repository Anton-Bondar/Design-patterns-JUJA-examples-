package com.anbo.juja.patterns.observer_04.sample.soft;

import java.util.Set;

public interface Vacancy {

    // вакансия сожержит набор требуемых технологий
    // вакансия умеет отвечать на вопрос, подходит ли ей список технологий или нет
	boolean check(Set<String> technologies);
    
}
