package queue;

/**
 * @ClassName: RunOne
 * @Description: 插入队列，输出队列大小
 * @author ZXY
 * @date 2016/8/2 17:01
 */
public class RunOne implements Runnable {
    @Override
    public void run() {
        QueuePool queuePool = QueuePool.getInstance();
        int count = 0;
        while (count < 10) {
            queuePool.offerOne(String.valueOf(Math.random()));
            try {
                Thread.sleep(1000L);
                count++;
                System.out.println("队列大小：" + queuePool.getBlockingQueue().size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
