package com.mayo.rxjava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

import java.util.Arrays;

/**
 * Created by mayo on 20/10/16.
 */
public class ArrayRx {

    public void stream() {
        String[] names = {"Muni", "Rekha"};
        Observable.from(names)
                .subscribe(s -> {
                    print("Hello, " + s + "..!");
                });
    }

    /**
     * Illustrates creating Observable using from and just methods
     */
    public void justFrom() {
        //just takes only objects but not arrays
        Observable<String> o = Observable.just("Hello, World", "Hello, Muni");

        //short-hand form
        //o.map(s -> s + " boom").subscribe(this::print);

        //with the implementation of callback methods
        o.map(s -> s + " boom").subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                print(s);
            }
        });

        String[] hellos = {"Hello, World", "Hello, Muni"};
        Observable<String> oo = Observable.from(Arrays.asList(hellos));
        oo.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                print("Observed: " + s);
            }
        });
        /*
         //the below statement causes compile-time error since just only accepts variable objects
         Observable<String> o = Observable.just(Arrays.asList(hellos));
        */

    }

    /**
     * Illustrates how to create an Observable(Stream) and subscribe (add observer) to it.
     */
    public void create() {
        //creating an Observable or Stream that can emit data.
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> sub) {
                for (int i = 0; i < 5; i++)
                    //emitting data
                    sub.onNext("Hello, World!");

                //finishing emitting data
                sub.onCompleted();
            }
        });

        //creating subscriber or observer to consume the emitted data
        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                //consume the emitted data
                print(s);
            }
        });
    }

    private void print(Object o) {
        System.out.println(o);
    }
}
