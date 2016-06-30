package ConcurrentHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Martin on 2015/11/24.
 */
public class SynchronizedThread extends Thread {

    private static Map<Integer, Integer> map   = new HashMap<Integer, Integer>();
    public         long                  count = 0;

    static {
        ConMap.fillMap(map);
    }

    @Override
    public void run() {
        for (;;){
            int index = (int)(count % ConMap.KEYS.length);
            synchronized (SynchronizedThread.class){
                map.get(ConMap.KEYS[index]);
            }
            ++ count;
        }
    }
}
