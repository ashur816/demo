package multithreading;

/**
 * Created by Martin on 2015/11/24.
 */
public class TicketCountThread implements Runnable {
    static int countTotal = 90;
    //线程池大小
    static int threadCount = Math.min(10, countTotal);

    public static void main(String[] args) {
        //每个线程处理数量
        final int taskSize = countTotal % threadCount == 0 ? countTotal / threadCount : countTotal / threadCount + 1;
        System.out.println("JOB:处理列表大小-" + countTotal + "，线程数-" + threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int j = i;
            new Thread(new Runnable() {
                public void run() {
                    for (int c = taskSize * j; c < taskSize * (j + 1) && c < countTotal; c++) {
                        System.out.println(Thread.currentThread() + "正在购买第" + (c+1) + "张票");
                    }
                }
            }).start();
        }
    }

    @Override
    public void run() {

    }
}
