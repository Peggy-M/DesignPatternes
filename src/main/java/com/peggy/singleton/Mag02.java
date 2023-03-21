package com.peggy.singleton;


/**
 * 单例模式 饿汉式模式
 * @author peggy
 * @date 2023-03-21 18:17
 */
public class Mag02 {
    private static Mag02 INSTANCE = null;

    private Mag02() {
    }

    public static Mag02 getINSTANCE() {
        //线程安全问题
        if (INSTANCE == null) {
            /*try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            INSTANCE = new Mag02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mag02.getINSTANCE());
            }).start();
        }
    }
}
