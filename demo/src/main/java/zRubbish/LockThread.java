package zRubbish;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Martin on 2015/11/24.
 */
public class LockThread extends Thread {
    private static Map<Integer, Integer> map   = new HashMap<Integer, Integer>();
    private static Lock                  lock  = new ReentrantLock();
    public         long                  count = 0;

    static {
        ThreadMain.fillMap(map);
    }

    @Override
    public void run() {
        for (; ; ) {
            int index = (int) (count % ThreadMain.KEYS.length);
            lock.lock();
            map.get(ThreadMain.KEYS[index]);
            lock.unlock();
            ++count;
        }
    }
}
