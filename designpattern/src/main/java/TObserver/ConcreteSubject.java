package TObserver;

/**
 * @author ZXY
 * @ClassName: ConcreteSubject
 * @Description: 具体目标
 * @date 2017/3/31 15:15
 */
class ConcreteSubject extends Subject {
    @Override
    public void notice() {
        //遍历观察者集合，调用每一个观察者的响应方法
        for (Object obs : observerInfList) {
            ((ObserverInf) obs).update();
        }
    }
}
