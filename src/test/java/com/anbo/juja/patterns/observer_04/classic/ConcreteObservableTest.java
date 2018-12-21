package com.anbo.juja.patterns.observer_04.classic;

import org.junit.Test;
import ua.com.juja.patterns.observer.classic.ConcreteObservable;
import ua.com.juja.patterns.observer.classic.Observable;
import ua.com.juja.patterns.observer.classic.Observer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by oleksandr.baglai on 09.09.2015.
 */
public class ConcreteObservableTest {

    @Test
    public void testNotifyAll() {
        // given
        Observable observable = new ConcreteObservable();

        Observer observer1 = mock(Observer.class);
        observable.addObserver(observer1);

        Observer observer2 = mock(Observer.class);
        observable.addObserver(observer2);

        // when
        observable.notifyObservers("data");

        // then
        verify(observer1).handleEvent("data");
        verify(observer2).handleEvent("data");
    }

    @Test
    public void testNotifyOnlySubscribed() {
        // given
        Observable observable = new ConcreteObservable();

        Observer observer1 = mock(Observer.class);
        observable.addObserver(observer1);

        Observer observer2 = mock(Observer.class);
        observable.addObserver(observer2);

        // when
        observable.removeObserver(observer1);
        observable.notifyObservers("data");

        // then
        verifyNoMoreInteractions(observer1);
        verify(observer2).handleEvent("data");
    }
}
