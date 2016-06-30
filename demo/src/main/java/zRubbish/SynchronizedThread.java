package zRubbish;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Martin on 2015/11/24.
 */
public class SynchronizedThread extends Thread {

    private static Map<Integer, Integer> map   = new HashMap<Integer, Integer>();
    public         long                  count = 0;

    static {
        ThreadMain.fillMap(map);
    }

    @Override
    public void run() {
        for (;;){
            int index = (int)(count % ThreadMain.KEYS.length);
            synchronized (SynchronizedThread.class){
                map.get(ThreadMain.KEYS[index]);
            }
            ++ count;
        }
    }
}
