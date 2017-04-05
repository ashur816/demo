package TObserver;

/**
 * @author ZXY
 * @ClassName: ObserverMain
 * @Description:
 * @date 2017/3/31 16:30
 */
class ObserverMain {

    public static void main(String[] args) {
//        Observer o1 = new ConcreteObserver();
//        Observer o2 = new ConcreteObserver();
//        Subject subject = new ConcreteSubject();
//        subject.attach(o1);
//        subject.attach(o2);
//
//        subject.notice();

        //观察者
        JDKObserver o1 = new JDKObserver("貂蝉");
        JDKObserver o2 = new JDKObserver("吕布");
        JDKObserver o3 = new JDKObserver("董卓");

        //目标
        JDKObservable observable = new JDKObservable();
        observable.addObserver(o1);
        observable.addObserver(o2);
        observable.addObserver(o3);

        String s = o1.underAttack("受到攻击");
        //排除自己
        observable.notifyObservers(o1, s);
    }
}
