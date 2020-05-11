package cn.melon.singleton;

public class SingletonDemo2 {
    private volatile static SingletonDemo2 uniqueInstance;
    private SingletonDemo2(){}

    public static SingletonDemo2 getInstance(){
        if (uniqueInstance == null) {
            synchronized (SingletonDemo2.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonDemo2();
                }
            }
        }
        return uniqueInstance;
    }
}
