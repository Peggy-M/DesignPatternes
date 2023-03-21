package com.peggy.singleton;

/**
 * 通过枚举的形式获取单利对象,解决线程同步，防止反序列化
 * @author peggy
 * @date 2023-03-21 15:34
 */
public enum Mag06 {
    INSTANCE(1);

    Mag06(int i) {
        System.out.println("i=" + i);
    }

    public static void main(String[] args) {
        final Mag06 instance = Mag06.INSTANCE;
        System.out.println(instance);
    }
}
