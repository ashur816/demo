package TObserver;

import java.util.Observable;
import java.util.Observer;

/**
 * @author ZXY
 * @ClassName: JDKObservable
 * @Description: 具体目标
 * @date 2017/4/1 14:17
 */
class JDKObservable extends Observable {

    @Override
    public void notifyObservers() {
        super.setChanged();
        super.notifyObservers();
    }

    public void notifyObservers(Observer observer, Object arg) {
        super.deleteObserver(observer);
        super.setChanged();
        super.notifyObservers(arg);
    }

}
