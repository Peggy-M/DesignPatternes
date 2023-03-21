package com.peggy.singleton;

/**
 * 通过静态内部类的方式
 * 这种方式其实是利用了 JVM 对于静态内部类的类似于懒加载的这种时机进行设计的
 * @author peggy
 * @date 2023-03-21 19:15
 */
public class Mag05 {

    //静态内部类的加载时机是在第一次调用静态内部类的方法或者内部类的成员变量的时候
    private static class Mag05Inter {
        private final static Mag05 INSTANCE = new Mag05();
    }

    public static Mag05 getInstance() {
        return Mag05Inter.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(getInstance());
            }).start();
        }
    }
}
