package cn.melon.singleton;

public class SingleTonDemo1 {
    private static SingleTonDemo1 uniqueInstance;
    private SingleTonDemo1(){}

    public static synchronized  SingleTonDemo1 getInstance(){
        if (uniqueInstance == null) {
            uniqueInstance = new SingleTonDemo1();
        }
        return uniqueInstance;
    }
}
