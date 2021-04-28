package ru.geekbrains.java3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {

    private final CyclicBarrier startCyclicBarrier;
    private final CyclicBarrier finishCyclicBarrier;
    private final Race race;
    private final int speed;
    private final String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, int name, CyclicBarrier startCyclicBarrier, CyclicBarrier finishCyclicBarrier) {
        this.race = race;
        this.speed = speed;
        this.name = "Участник #" + name;
        this.startCyclicBarrier = startCyclicBarrier;
        this.finishCyclicBarrier = finishCyclicBarrier;

    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            startCyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            if (i == (race.getStages().size() - 1)) {
                System.out.println(this.name + " финишировал");
                Main.isWinner = doWinnerCheck(Main.isWinner);
            }

        }
        try {
            finishCyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    public synchronized boolean doWinnerCheck(boolean isWinner) {
        if (!isWinner) {
            Main.winnerGreetings = "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> " + this.name + " - победитель!";
            return true;
        }
        return true;
    }
}
