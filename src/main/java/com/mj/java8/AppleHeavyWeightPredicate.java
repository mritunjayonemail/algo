package com.mj.java8;

public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return 150> apple.getWeight();
    }
}
