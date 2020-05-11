# DesignPattern
### Singleton Pattern
> 确保一个类只有一个实例，并提供一个全局访问点

* 关注点一---线程安全问题（解决方案：
    * 方案一：
    ```
    private static SingleTonDemo1 uniqueInstance;
    private SingleTonDemo1(){}
    public static synchronized  SingleTonDemo1 getInstance(){
       if (uniqueInstance == null) {
           uniqueInstance = new SingleTonDemo1();
       }
       return uniqueInstance;
    }
    ```
  > 将getInstance()设为synchronized方法，可以轻松解决线程安全问题  
  > (但是，实际上只有第一个执行该方法时才需要同步，所以将整个方法都同步降低性能)

    * 方案二：
    ```
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
    ```
  > 这样，只有第一次执行getInstance()时会同步
  > (volatile + synchronized + 双重检查加锁)

* 关注点二----适用性：
    * 同步getInstance()方法 ---- 延迟加载，没有性能的要求
    * 饿汉式 ---- 无线程问题，启动慢
    * 双重检查加锁 ---- 延迟加载，满足性能要求

