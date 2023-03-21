package com.peggy.singleton;

/**
 * 饿汉式 线程安全
 * @author peggy
 * @date 2023-03-21 18:47
 */
public class Mag03 {
    private static Mag03 INSTANCE = null;
    private static Object lock = new Object();

    private Mag03() {
    }

    public static Mag03 getINSTANCE() {
        if (INSTANCE == null) {
            //这里线程不安全
            /*try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            synchronized (lock) {
                INSTANCE = new Mag03();
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
