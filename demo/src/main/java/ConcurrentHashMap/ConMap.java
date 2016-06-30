package ConcurrentHashMap;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Martin on 2015/11/24.
 */
public class ConMap {

    public static final int   THREAD_COUNT     = 1;
    public static final int   MAP_SIZE         = 1000;
    public static final int   EXECUTION_MILLES = 1000;
    public static final int[] KEYS             = new int[100];

    ConcurrentHashMap hMap = new ConcurrentHashMap();

    public static void fillMap(Map<Integer, Integer> map) {
        Random ra = new Random();
        for (int i = 0; i < MAP_SIZE; i++) {
            map.put(ra.nextInt(), ra.nextInt());
        }
    }

    public static void main(String[] args) {

        Random ra = new Random();
        for (int i = 0; i < KEYS.length; i++) {
            KEYS[i] = ra.nextInt();
        }

        //开始创建
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new SynchronizedThread();
        }
    }
}

