package com.liaosl.java8;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class SimpleStream {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800,Dish.Type.META),
                new Dish("beef",false,700,Dish.Type.META),
                new Dish("chicken",false,400,Dish.Type.META),
                new Dish("french fries",true,530,Dish.Type.OTHER),
                new Dish("rice",true,350,Dish.Type.OTHER),
                new Dish("season fruit",true,120,Dish.Type.OTHER),
                new Dish("pizza",true,550,Dish.Type.OTHER),
                new Dish("prawns",false,300,Dish.Type.FISH),
                new Dish("salmon",false,450,Dish.Type.FISH)
        );
//        Stream<Dish> stream = menu.stream();
//        stream.forEach(System.out::println);

        List<String> collect = menu.stream().filter(d -> {
            System.out.println("filtering ->" + d.getName());
            return d.getCalories() > 300;
        }).map(d -> {
            System.out.println("map->" + d.getName());
            return d.getName();
        }).limit(3).collect(toList());

        System.out.println(collect);

//        List<String> dishNamesByColletions = getDishNamesByColletions(menu);
//        System.out.println(dishNamesByColletions);

//        List<String> dishNamesByStream = getDishNamesByStream(menu);
//        System.out.println(dishNamesByStream);

    }


    private static List<String> getDishNamesByStream(List<Dish> menu){
        return menu.stream().filter(d ->
                {
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return d.getCalories() < 400;
                }
                ).sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName).collect(toList());
    }

    private static List<String> getDishNamesByColletions(List<Dish> menu){
        List<Dish> lowColaies = new ArrayList<>();
        for (Dish dish : menu) {
            if(dish.getCalories()<400){
                lowColaies.add(dish);
            }
        }

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Collections.sort(lowColaies,(d1,d2) -> Integer.compare(d1.getCalories(),d2.getCalories()));
        List<String> dishNameList = new ArrayList<>();
        for (Dish lowColay : lowColaies) {
            dishNameList.add(lowColay.getName());
        }
        return dishNameList;
    }

}
