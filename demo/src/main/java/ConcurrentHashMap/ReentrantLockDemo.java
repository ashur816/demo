package ConcurrentHashMap;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZXY
 * @ClassName: ReentrantLockDemo
 * @Description:
 * @date 2017/3/20 14:26
 */
public class ReentrantLockDemo {

    public static void main(String[] args) throws Exception {
        final ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0; i < 5; i++) {
            final Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 1;
                    Thread curThread = Thread.currentThread();
                    try {
                        for (; ; ) {
                            if (reentrantLock.tryLock()) {
                                System.out.println(curThread + "获取锁成功");
                                count++;
                                reentrantLock.unlock();
                                curThread.sleep(1000L);
                                if (count == 5) {
                                    curThread.interrupt();
                                    System.out.println(curThread + "终端指令");
                                }
                            }
                        }
                    } catch (Exception e) {

                    }
                }
            });
            thread.start();
        }
    }
}
