package ru.geekbrains.java3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {

    protected static final int CARS_COUNT = 4;
    protected static boolean isWinner;
    protected static String winnerGreetings;


    public static void main(String[] args) {
        CyclicBarrier startCyclicBarrier = new CyclicBarrier(CARS_COUNT + 1);
        CyclicBarrier finishCyclicBarrier = new CyclicBarrier(CARS_COUNT + 1);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(80, CARS_COUNT / 2), new Road(40));

        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), (i + 1), startCyclicBarrier, finishCyclicBarrier);
        }

        for (Car car : cars) {
            new Thread(car).start();
        }

        useCyclicBarrier(startCyclicBarrier, "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        useCyclicBarrier(finishCyclicBarrier, "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        System.out.println(winnerGreetings);

    }

    private static void useCyclicBarrier(CyclicBarrier cyclicBarrier, String message) {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }

}
