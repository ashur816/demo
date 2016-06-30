package interfaceImpl;

/**
 * Created by Martin on 2015/11/24.
 */
public class AlarmDoor extends Door implements Alarm {

    @Override
    public void alarm() {

    }

    @Override
    public void open() throws Exception {

    }

    @Override
    public void close() throws Exception {

    }

    public static void main(String[] args) throws Exception {
        AlarmDoor a = new AlarmDoor();
        Alarm s = a instanceof Alarm ? ((Alarm) a) : null;
    }
}
