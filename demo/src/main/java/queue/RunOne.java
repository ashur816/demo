package queue;

/**
 * @ClassName: RunOne
 * @Description:
 * @author ZXY
 * @date 2016/8/2 17:01
 */
public class RunOne implements Runnable {
    @Override
    public void run() {
        QueuePool queuePool = QueuePool.getInstance();
        int count = 0;
        while (count < 10) {
            queuePool.addOne(String.valueOf(Math.random()));
            try {
                Thread.sleep(1000L);
                count++;
                System.out.println(queuePool.getBlockingQueue().size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
