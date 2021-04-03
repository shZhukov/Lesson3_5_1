package ru.geekbrains.Lesson3_5_1;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage{
    private Semaphore semaphor = new Semaphore(MainClass.CARS_COUNT / 2);
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {

            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphor.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphor.release();
            }

    }
}
