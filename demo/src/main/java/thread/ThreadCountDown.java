package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author ZXY
 * @ClassName: ThreadCountDown
 * @Description:
 * @date 2017/3/27 13:25
 */
public class ThreadCountDown {

    private static final int MAX_WORK_DURATION = 5000;  // 最大工作时间
    private static final int MIN_WORK_DURATION = 1000;  // 最小工作时间

    // 产生随机的工作时间
    private static long getRandomWorkDuration(long min, long max) {
        return (long) (Math.random() * (max - min) + min);
    }

    public static void main(String[] args) throws Exception {

        final CountDownLatch latch = new CountDownLatch(2);
        final Worker worker1 = new Worker("张三", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
        final Worker worker2 = new Worker("李四", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker1.doWork();
                    latch.countDown();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker2.doWork();
                    latch.countDown();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();


        latch.await();
        System.out.println("所有工作都已完成");
    }
}

class Worker {

    private String name;
    private long workerTime;


    public Worker(String name, long workerTime) {
        this.name = name;
        this.workerTime = workerTime;
    }

    public void doWork() throws Exception {
        System.out.println(name + "开始工作");
        Thread.sleep(workerTime);
        System.out.println(name + "工作结束");
    }
}
