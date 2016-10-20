package com.mayo.rxjava;

import rx.Observable;
import rx.Subscriber;

import java.util.Arrays;

/**
 * Created by mayo on 20/10/16.
 */
public class ArrayDemo {

    ArrayDemo() {
        String[] names = {"Muni", "Rekha"};

        //rxJava
        print("----------------------------");
        print("RxJava");
        print("----------------------------");
        Observable.from(names)
                .subscribe(s -> {
                    print("Hello, " + s + "..!");
                });


        //Java8
        print("----------------------------");
        print("Java8");
        print("----------------------------");
        Arrays.stream(names).forEach(name -> print("Hello, " + name + "..!"));
    }

    public void justFrom() {
        String[] hellos = {"Hello, World", "Hello, Muni"};

        //RxJava
        //just takes only objects but not arrays
        Observable<String> o = Observable.just("Hello, World", "Hello, Muni");
        /*
         //the below statement causes compile-time error since just only accepts variable objects
         Observable<String> o = Observable.just(Arrays.asList(hellos));
         Observable<String> o = Observable.from(Arrays.asList(hellos));
        */

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

        //Java8
        //Arrays.stream(hellos).map(s -> s+" boom").forEach(s->print(s));
        //Arrays.stream(hellos).map(s -> s+" boom").forEach(this::print);
    }

    private void print(Object o) {
        System.out.println(o);
    }
}
