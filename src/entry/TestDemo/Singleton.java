package entry.TestDemo;

import lombok.val;

public class Singleton {
    private Singleton() {}
    private static volatile Singleton singleton = null;
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    Singleton singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
