package multithreading;

/**
 * Created by Martin on 2015/11/24.
 */
public class TicketCountThread implements Runnable {
    static long count = 1000;

    public static void main(String[] args) {
        TicketCountThread m = new TicketCountThread();
        Thread t = null;
        for (int i = 0; i < count; i++) {
            t = new Thread(m);
            t.start();
        }
    }

    @Override
    public void run() {
        if (count > 0) {
            System.out.println(Thread.currentThread() + "正在购买第" + count-- + "张票");
        }
    }
}
