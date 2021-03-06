package com.liaosl.java8;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamMap {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,7,1);

        List<Integer> result = list.stream().map(i -> i * 2).collect(toList());

        System.out.println(result);

        System.out.println("==============");

        listDish().stream().map(dish -> dish.getName()).forEach(System.out::println);

        List<String> dishes = listDish().stream().map(dish -> dish.getName()).collect(toList());

        System.out.println(dishes);


        String[] words = {"Hello","World"};

        Arrays.stream(words).map(w ->w.split(""));

    }

    private static List<Dish> listDish(){
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800,Dish.Type.META),
                new Dish("beef",false,700,Dish.Type.META),
                new Dish("chicken",false,400,Dish.Type.META),
                new Dish("french fries",true,530,Dish.Type.OTHER),
                new Dish("rice",true,350,Dish.Type.OTHER),
                new Dish("season fruit",true,120,Dish.Type.OTHER),
                new Dish("pizza",true,550,Dish.Type.OTHER),
                new Dish("prawns",false,300,Dish.Type.FISH),
                new Dish("salmon",false,450,Dish.Type.FISH));
        return menu;
    }
}
