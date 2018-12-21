package com.anbo.juja.patterns.observer_04.sample.hard;

import java.util.Collection;

public interface Candidate {
    
    // кандидат умеет получать уведомления о вакансиях
	void haveANew(Collection<Vacancy> vacancies);
    
}
