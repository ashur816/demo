package thread;

/**
 * Created by Martin on 2015/11/24.
 */
public class ThreadSync1 extends Thread {
    private int threadNo;

    ThreadSync1(int threadNo) {
        this.threadNo = threadNo;
    }

    public static synchronized void lock(int threadNo) {
        for (int i = 0; i < 100; i++) {
            System.out.println("thread[" + threadNo + "],number[" + i + "]");
        }
    }

    @Override
    public void run() {
        lock(threadNo);
    }
}
