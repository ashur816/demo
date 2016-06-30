package zRubbish;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Martin on 2015/11/24.
 */
public class ConMapThread extends Thread {
    private static Map<Integer, Integer> map   = new ConcurrentHashMap<Integer, Integer>();
    public         long                  count = 0;

    static {
        ThreadMain.fillMap(map);
    }

    @Override
    public void run() {
        for (; ; ) {
            int index = (int) (count % ThreadMain.KEYS.length);
            map.get(ThreadMain.KEYS[index]);
            ++count;
        }
    }
}
