package TObserver;

/**
 * @author ZXY
 * @ClassName: ConcreteObserver
 * @Description: 具体观察者
 * @date 2017/3/31 15:15
 */
class ConcreteObserverInf implements ObserverInf {
    @Override
    public void update() {
        System.out.println("我更新了");
    }
}
