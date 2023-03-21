package com.peggy.singleton;


import java.util.concurrent.TimeUnit;

/**
 * 饿汉式 线程安全 双重检测锁
 * @author peggy
 * @date 2023-03-21 18:47
 */
public class Mag04 {
    private static Mag04 INSTANCE = null;
    private static Object lock = new Object();

    private Mag04() {
    }

    public static Mag04 getINSTANCE() {

        if (INSTANCE == null) {
            synchronized (lock) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(INSTANCE ==null){
                    INSTANCE = new Mag04();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mag04.getINSTANCE());
            }).start();
        }
    }
}