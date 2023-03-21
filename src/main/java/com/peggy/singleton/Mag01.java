package com.peggy.singleton;

/**
 * 单利模式 懒汉式
 * @author peggy
 * @date 2023-03-21 18:16
 */
public class Mag01 {

    //定义一个静态内部对象
    private final static Mag01 INSTANCE = new Mag01();

    //私有构造方法,用户无法创建实例对象
    private Mag01() {
    }

    //对外提供获取对象方法
    public static Mag01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mag01.getInstance());
            }).start();
        }
    }

}
