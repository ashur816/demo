package ConcurrentHashMap;

import java.util.Map;
import java.util.Random;

/**
 * @author ZXY
 * @ClassName: ConMap
 * @Description: 通过分析Hashtable就知道，synchronized是针对整张Hash表的，即每次锁住整张表让线程独占，ConcurrentHashMap允许多个修改操作并发进行，其关键在于使用了锁分离技术。
 * 它使用了多个锁来控制对hash表的不同部分进行的修改。ConcurrentHashMap内部使用段(Segment)来表示这些不同的部分，每个段其实就是一个小的hash table，它们有自己的锁。
 * 只要多个修改操作发生在不同的段上，它们就可以并发进行。有些方法需要跨段，比如size()和containsValue()，它们可能需要锁定整个表而而不仅仅是某个段，这需要按顺序锁定所有段，操作完毕后，又按顺序释放所有段的锁。
 * 这里“按顺序”是很重要的，否则极有可能出现死锁，在ConcurrentHashMap内部，段数组是final的，并且其成员变量实际上也是final的，但是，仅仅是将数组声明为final的并不保证数组成员也是final的，这需要实现上的保证。
 * 这可以确保不会出现死锁，因为获得锁的顺序是固定的。
 * @date 2017/3/13 9:57
 */
public class ConMap {

    public static final int THREAD_COUNT = 1;
    public static final int MAP_SIZE = 10;
    public static final int EXECUTION_MILLES = 1000;
    public static final int[] KEYS = new int[10];

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

