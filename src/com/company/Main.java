package com.company;

public class Main {

    public static void main(String[] args) {

        ClassicThread t1 = new ClassicThread("Первый");
        ClassicThread t2 = new ClassicThread("Второй");

        try {
            Thread.sleep(1000);
            t1.suspend();
            System.out.println("Первый поток приостановлен");
            Thread.sleep(1000);
            t1.resume();
            System.out.println("Первый поток возобнавлен");
            t2.suspend();
            System.out.println("Второй поток приостановлен");
            Thread.sleep(1000);
            t2.resume();
            System.out.println("Второй поток возобнавлен");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Ожидание завершения потоков");
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }

        System.out.println("Главный поток завершён");


    }
}
