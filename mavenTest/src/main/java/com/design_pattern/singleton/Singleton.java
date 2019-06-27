package com.design_pattern.singleton;

public class Singleton {

    private volatile Singleton instance;

    private Singleton() {
    }

    /**
     * 单例模式 非线程安全
     * @return
     */
//    public Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    /**
     * 单例模式 线程安全 锁代价大
     *
     * @return
     */
//    public Singleton getInstance() {
//        synchronized (this) {
//            if (instance == null) {
//                instance = new Singleton();
//            }
//            return instance;
//        }
//    }


    /**
     * 线程安全 代价小 但会收到指令重排的影响(reorder)
     * 正常情况下
     * 1 分配内存
     * 2 初始化对象（加载内存）
     * 3 返回内存地址
     *
     * 指令重排之后
     * 1 分配内存
     * 2 返回内存地址
     * 3 初始化对象（加载内存）
     *
     * 当线程1指令重排之后执行到【2 返回内存地址】的时候，instance已经不为空了
     * 此时线程2获取实例的时候第一个判断instance不为空，这时会直接返回instance，但是此时的instance是未加载完成的，是不能用的
     * @return
     */
//    public Singleton getInstance() {
//        if (instance == null) {
//            synchronized (this) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    /**
     * 当instance被volatile修饰的时候，CPU处理的时候不会发生指令重排，保证了执行的有序性和原子性
     * @return
     */
    public Singleton getInstance() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


}
