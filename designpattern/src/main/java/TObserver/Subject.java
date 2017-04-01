package TObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZXY
 * @ClassName: Subject
 * @Description: 目标
 * @date 2017/3/31 15:14
 */
abstract class Subject {

    //定义一个观察者集合用于存储所有观察者对象
    protected List<ObserverInf> observerInfList = new ArrayList<>();

    //注册方法，用于向观察者集合中增加一个观察者
    public void attach(ObserverInf observerInf){
        observerInfList.add(observerInf);
    }

    //注销方法，用于在观察者集合中删除一个观察者
    public void detach(ObserverInf observerInf){
        observerInfList.remove(observerInf);
    }

    //声明抽象通知方法
    public abstract void notice();
}
