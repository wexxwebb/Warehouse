package com.pervushow.semaphore;

public class Supplier {

    private GunWarehouse gunWarehouse = new GunWarehouse();
    private KnifeWarehouse knifeWarehouse = new KnifeWarehouse();
    private BFGWarehouse bfgWarehouse = new BFGWarehouse();

    public void supply(int guns, int knifes, int bfgs) {
        Thread gunAdd = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (gunWarehouse) {
                    for (int i = 0; i < guns; i++) {
                        gunWarehouse.add();
                    }
                }
            }
        });
        gunAdd.start();

        Thread knifeAdd = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (knifeWarehouse) {
                    for (int i = 0; i < knifes; i++) {
                        knifeWarehouse.add();
                    }
                }
            }
        });
        knifeAdd.start();

        Thread bfg = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (bfgWarehouse) {
                    for (int i = 0; i < bfgs; i++) {
                        bfgWarehouse.add();
                    }
                }
            }
        });
        bfg.start();

    }
}
