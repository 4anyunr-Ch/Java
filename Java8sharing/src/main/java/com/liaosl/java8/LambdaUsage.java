package com.liaosl.java8;

import sun.applet.AppletListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class LambdaUsage {

    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if(predicate.test(a)){
                result.add(a);
            }
        }
        return result;
    }

    private static List<Apple> filterbyWeight(List<Apple> source, LongPredicate predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if(predicate.test(apple.getWeight())){
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String,Long> predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if(predicate.test(a.getColor(),a.getWeight())){
                result.add(a);
            }
        }
        return result;
    }

    private static void testConsumer(List<Apple> list,Consumer<List<Apple>> consumer){
        consumer.accept(list);
    }

    private static void testSimpleConsumer(List<Apple> list, String name, BiConsumer biConsumer){
        for (Apple apple : list) {
            biConsumer.accept(apple.getColor(),name);
        }
    }

    private static String testFunction(Apple apple,Function<Apple,String> function){
        return function.apply(apple);
    }

    private static Apple testFunction(String color,long weight,BiFunction<String,Long,Apple> fun){
        return fun.apply(color,weight);
    }


    public static void main(String[] args) {
//        Runnable r1 = () -> System.out.println("Hello");
//
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello");
//            }
//        };
//
//        process(r1);
//        process(r2);
//        process(() -> System.out.println("Hello"));

        List<Apple> list = Arrays.asList(new Apple("green",120),new Apple("red",150));

//        List<Apple> greenList = filter(list,(apple) -> apple.getColor().equals("green"));
//        System.out.println(greenList);
//
//        List<Apple> result = filterbyWeight(list,w -> w > 100);
//        System.out.println(result);
//
//        List<Apple> result2 = filterByBiPredicate(list, (s, w) -> s.equals("green") && w > 100);
//        System.out.println(result2);

//        testConsumer(list,a->{
//            for (Apple apple : a) {
//                System.out.println(a.toString());
//             }
//        });

//        testSimpleConsumer(list,"forest",(a,s) -> System.out.println(a.toString()+s));

//        String red = testFunction(new Apple("red", 102), a -> a.toString());
//        System.out.println(red);

//        IntFunction<String> f = i -> String.valueOf(i*100);
//        String apply = f.apply(200);
//        System.out.println(apply);

//        Apple blue = testFunction("Blue", 130, (s, w) -> new Apple(s, w));
//        System.out.println(blue);

//        Supplier<String> s = String :: new;
//        System.out.println(s.get().getClass());

        Apple green = createApple(() -> new Apple("Green", 100));
        System.out.println(green);
    }

    private static void process(Runnable r){
        r.run();
    }

    private static Apple createApple(Supplier<Apple> supplier){
        return supplier.get();
    }

}
