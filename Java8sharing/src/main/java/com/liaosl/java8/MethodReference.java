package com.liaosl.java8;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class MethodReference {
    public static void main(String[] args) {

    }

    private static <T> void useConsumer(Consumer<T> consumer,T t){
        consumer.accept(t);

    }
}
