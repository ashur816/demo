package DSingleton;

/**
 * @ClassName: EagerSingleton
 * @Description: 饿汉式单例
 * @author ZXY
 * @date 2016/5/17 17:43
 */
class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {

    }

    EagerSingleton getInstance() {
        return instance;
    }

}
