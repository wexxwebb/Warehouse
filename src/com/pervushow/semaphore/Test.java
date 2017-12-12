package com.pervushow.semaphore;

public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        });

        thread.start();
        try {
            thread.wait();
            thread.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
