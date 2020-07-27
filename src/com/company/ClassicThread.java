package com.company;

public class ClassicThread implements Runnable {

    private String name;
    private Thread t;
    private boolean suspendFlag;

    public ClassicThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("Новый поток создан: " + t);
        suspendFlag = false;
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
            catch(InterruptedException e){
                System.out.println(name + " прерван");
            }
        }
        System.out.println(name + " завершен");
    }

    synchronized void suspend(){
        suspendFlag = true;
    }

    synchronized void resume(){
        suspendFlag = false;
        notify();
    }

    void join() throws InterruptedException {
        t.join();
    }
}
