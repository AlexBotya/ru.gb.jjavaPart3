package ru.geekbrains.java3.lesson1Generics.task3;

public class Orange extends Fruit{
    private static final float weight = 1.5f;

    public Orange() {
        super(weight);
    }

    public float getWeight() {
        return weight;
    }
}

