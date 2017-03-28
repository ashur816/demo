package thread;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZXY
 * @ClassName: ThreadSync
 * @Description:
 * @date 2017/3/23 16:36
 */
public class ThreadSync {

    public static void main(String[] args) {
        final CountMain countMain = new CountMain();
        final Set<Integer> set = new HashSet<>();
        final Map map = new HashMap();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    int count = countMain.cNoSync();
//                    int count = countMain.cSyncMethod();
//                    int count = countMain.cSyncBlock();
                    int count = countMain.cSyncReentrantLock();
                    String s = Thread.currentThread().getName();
                    if (set.contains(count)) {
                        System.out.println("重复元素-" + count + "==>" + map.get(count) + "==>" + s);
                    } else {
                        map.put(count, s);
                        set.add(count);
                    }
                }
            }).start();
        }
    }
}

class CountMain {

    private static int count = 0;

    public int cNoSync() {
        count++;
        return count;
    }

    //同步方法
    public synchronized int cSyncMethod() {
        count++;
        return count;
    }

    //同步块
    private byte[] lock = new byte[0]; // 特殊的instance变量 开销最小3行指令 Object object= new Object() 7条指令
    public int cSyncBlock() {
        synchronized (lock) {
            count++;
            return count;
        }
//        return count; //不能写在同步代码块外面，要不然返回是可以并发的
    }

    //可重入锁
    private ReentrantLock rLock = new ReentrantLock();
    public int cSyncReentrantLock() {
        rLock.lock();
        try {
            count++;
            return count;
        } finally {
            rLock.unlock();
        }
    }

}

