package LFlyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZXY
 * @ClassName: FlyweightFactory
 * @Description: 享元工厂类
 * @date 2017/3/30 13:43
 */
class FlyweightFactory {

    private Map<String, Flyweight> cMap = new ConcurrentHashMap<>();

    public FlyweightFactory() {
        cMap.put("b", new ConcreteFlyweightB());
        cMap.put("w", new ConcreteFlyweightW());

    }

    public static FlyweightFactory getInstance() {
        return HoldClass.factory;
    }

    public Flyweight getFlyweight(String color) {
        return cMap.get(color);
    }

    static class HoldClass {
        public static FlyweightFactory factory = new FlyweightFactory();
    }

}
