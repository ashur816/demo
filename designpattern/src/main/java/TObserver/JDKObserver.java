package TObserver;

import java.util.Observable;
import java.util.Observer;

/**
 * @author ZXY
 * @ClassName: JDKObserver
 * @Description: 观察者
 * @date 2017/4/1 14:01
 */
class JDKObserver implements Observer {

    private String name;

    public JDKObserver(String name) {
        this.name = name;
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + "收到：" + arg);
    }

    public String underAttack(Object arg) {
        System.out.println(name + arg);
        return name + arg;
    }
}
