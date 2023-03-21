package com.peggy.singleton;

/**
 * 静态内部类的加载时机测试
 * @author peggy
 * @date 2023-03-21 19:26
 */
public class StataicInnerClass {
    public StataicInnerClass() {
        System.out.println("类" + IntStataicClass.class.getName() + "初始化加载.....");
    }

    public static class IntStataicClass {

        public static Object obj = new Object();

        private IntStataicClass() {
            System.out.println("静态内部类" + IntStataicClass.class.getName() + "初始化加载.....");
        }
        //获取内部类的对象
        public static IntStataicClass getIntStataicClass(){
            return new IntStataicClass();
        }

    }
    //外类掉创建内部类对象
    public void getIntStataicClassLoader(){
        final IntStataicClass intStataicClass = new IntStataicClass();
    }

    //外类方法内部类的成员变量
    public void getIntStaticClassObj(){
        System.out.println(IntStataicClass.obj);
    }
    public static void main(String[] args) {
        System.out.println("====================1======================");
        System.out.println("构建 StataicInnerClass 对象");
        StataicInnerClass stataicInnerClass = new StataicInnerClass();
        System.out.println("====================2======================");
        stataicInnerClass.getIntStaticClassObj();
        System.out.println("====================3======================");
        new StataicInnerClass().getIntStataicClassLoader();
        System.out.println("调用内部类获取对象");
        StataicInnerClass.IntStataicClass.getIntStataicClass();
    }
}
