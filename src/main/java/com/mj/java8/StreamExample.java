package com.mj.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String args[]){
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        List<String> lowCaloriesDishName = menu.stream().filter((Dish dish) -> dish.getCalories()<200)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName).collect(Collectors.toList());
        for (String dishName: lowCaloriesDishName){
            System.out.println(dishName);
        }

        /*
        Intermediate operation -> filter, map, limit, sorted, distinct
        Terminal operation -> forEach, count, collect
         */

    }
}
