package com.liaosl.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApple {

    @FunctionalInterface
    public interface AppleFilter{
        boolean filter(Apple apple);
    }

    public static List<Apple> findApple(List<Apple> apples,AppleFilter appleFilter){
        List<Apple> list = new ArrayList<Apple>();
        for (Apple apple : apples) {
            if(appleFilter.filter(apple)){
                list.add(apple);
            }
        }
        return list;
    }

    public static class GreenAnd150WeightFilter implements AppleFilter{

        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("green") && apple.getWeight()>=160);
        }
    }

    public static List<Apple> findApple(List<Apple> apples,String color){
        List<Apple> list = new ArrayList<Apple>();
        for (Apple apple : apples) {
            if(color.equals(apple.getColor())){
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green",150),new Apple("yellow",300),new Apple("green",180));
//        List<Apple> greenaApple = findGreenApple(list);
//        assert greenaApple.size() == 2;

//        List<Apple> greenApples = findApple(list,"green");
//        System.out.println(greenApples);
//
//        List<Apple> redApples = findApple(list,"red");
//        System.out.println(redApples);

//        List<Apple> apple = findApple(list, new GreenAnd150WeightFilter());
//        System.out.println(apple);

//        List<Apple> yellowList = findApple(list, new AppleFilter() {
//            @Override
//            public boolean filter(Apple apple) {
//                return "yellow".equals(apple.getColor());
//            }
//        });
//        System.out.println(yellowList);

        List<Apple> lambdaResult = findApple(list, (Apple apple) -> {
            return apple.getColor().equals("green");
        });
        System.out.println(lambdaResult);
    }
}
