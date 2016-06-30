package lock;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Martin on 2015/11/24.
 * 两个代码块都要加sync
 */
public class RunnerMain {
    public static Map<Integer, Integer> map   = new HashMap<Integer, Integer>();
    private static long                  count = 1000;

    public static void fillMap() {
        for (int i = 0; i < count; i++) {
            map.put(i, i);
        }
    }

    public static int getValue(int key) {
        return map.get(key);
    }


    public static void main(String[] args) {
        fillMap();

        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();

        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);

        thread1.start();
        thread2.start();
    }
}
