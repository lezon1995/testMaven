package com.design_pattern.observer.demo;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * @author zhuliang
 * @date 2019/5/20 15:39
 */
public class ObserverDemo {
    public static void main(String[] args) {
        MyObservable observable = new MyObservable();

        observable.addObserver((o, value) -> System.out.println(value));

        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object value) {
                System.out.println(((Date) value).getTime());
            }
        });

        observable.setChanged();

        observable.notifyObservers(new Date());
    }

    public static class MyObservable extends Observable {
        /**
         * Marks this <tt>Observable</tt> object as having been changed; the
         * <tt>hasChanged</tt> method will now return <tt>true</tt>.
         */
        @Override
        public synchronized void setChanged() {
            super.setChanged();
        }
    }
}
