package thread;

/**
 * Created by Martin on 2015/11/24.
 */
public class ThreadSync2 extends Thread {
    private int    threadNo;
    private String lock;

    ThreadSync2(int threadNo, String lock) {
        this.threadNo = threadNo;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 100; i++) {
                System.out.println("thread[" + threadNo + "],number[" + i + "]");
            }
        }
    }
}
