package com.mj.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/*
A functional interface is an interface that specifies exactly one abstract methoD

public void process(Runnable r){
    r.run();
}

process(() -> System.out.println("This is awesome!!"));

akes no parameters and returns void. This is exactly the signature of the run method defined in the Runnable interface.


@FunctionalInterface
public interface Predicate<T>{
    boolean test(T t);
}

@FunctionalInterface
public interface Consumer<T>{
    void accept(T t);
}

@FunctionalInterface
public interface Function<T, R>{
    R apply(T t);
}
 */


public class ApplePredicateExample {

    Comparator<Apple> byWeight = new Comparator<Apple>() {
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    };

    Comparator<Apple> byWeight2 = (Apple apple1, Apple apple2) -> apple1.getWeight().compareTo(apple2.getWeight());

    private List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate){
        List<Apple> filteredApples = new ArrayList<Apple>();
        for(Apple apple: inventory){
            if(predicate.test(apple)){
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }

    private List<Apple> filterApples1(List<Apple> inventory, Predicate<Apple> predicate){
        List<Apple> filteredApples = new ArrayList<Apple>();
        for(Apple apple: inventory){
            if(predicate.test(apple)){
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }

    public static void main(String args[]){
        List<Apple> inventory = new ArrayList<Apple>();
        inventory.add(new Apple("green", 180));
        inventory.add(new Apple("green", 140));
        inventory.add(new Apple("red", 120));
        inventory.add(new Apple("red", 190));
        ApplePredicateExample applePredicateExample = new ApplePredicateExample();
        System.out.println("Green Apples");
        List<Apple> filteredApples = applePredicateExample.filterApples(inventory, new AppleGreenColorPredicate());
        for(Apple apple: filteredApples){
            System.out.println(apple.getColor() + " " + apple.getWeight());
        }

        System.out.println("Red Apples");
        filteredApples = applePredicateExample.filterApples1(inventory, (Apple apple) -> apple.getColor().equals("red"));
        for(Apple apple: filteredApples){
            System.out.println(apple.getColor() + " " + apple.getWeight());
        }

        System.out.println("Heavier apples");
        filteredApples = applePredicateExample.filterApples1(inventory, (apple) -> apple.getWeight()> 150);
        for(Apple apple: filteredApples){
            System.out.println(apple.getColor() + " " + apple.getWeight());
        }

        // local variables used inside lambda must be final or effectively final
        System.out.println("Local Variables");
        int portNumber = 211;
        Runnable r = () -> System.out.println(portNumber);
        r.run();
        //will throw error portNumber = 217;

        // Method referencing
        System.out.println("Sorted inventory");
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        inventory.sort(Comparator.comparing(Apple::getWeight));
        for(Apple apple: inventory){
            System.out.println(apple.getColor() + " " + apple.getWeight());
        }
        inventory.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor));
        for(Apple apple: inventory){
            System.out.println(apple.getColor() + " " + apple.getWeight());
        }

        // Compose Lambda function
        System.out.println("Lambda andThen ");
        Function<Integer, Integer> f =  (x) -> x+1;
        Function<Integer, Integer> g =  (x) -> x*2;
        Function<Integer, Integer> h = f.andThen(g);
        int z = h.apply(1);
        System.out.println(z);

        System.out.println("Lambda Compose ");
        Function<Integer, Integer> f1 =  (x) -> x+1;
        Function<Integer, Integer> g1 =  (x) -> x*2;
        Function<Integer, Integer> h1 = f1.compose(g1);
        int z1 = h1.apply(1);
        System.out.println(z1);


    }
}
