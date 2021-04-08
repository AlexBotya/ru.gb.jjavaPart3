package ru.geekbrains.java3.lesson1Generics.task3;

public class Apple extends Fruit {
    private static final float weight = 1f;

    public Apple() {
        super(weight);
    }


    @Override
    public float getWeight() {
        return weight;
    }
}
