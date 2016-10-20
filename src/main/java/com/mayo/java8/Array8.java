package com.mayo.java8;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by mayo on 20/10/16.
 */
public class Array8 {
    private String[] names = {"Muni", "Rekha"};

    /**
     * Creating streams from string array
     */
    public void stream() {
        //creating streams from String arrays
        Arrays.stream(names).forEach(name -> print("Hello, " + name + "..!"));
        Stream.of(names).forEach(this::print);
    }

    /**
     * Mapping data elements from stream
     */
    public void map() {
        Arrays.stream(names).map(s -> "Hello, " + s).forEach(s -> print(s));
        Arrays.stream(names).map(s -> "Hello, " + s).forEach(this::print);
    }

    private void print(Object o) {
        System.out.println(o);
    }
}
