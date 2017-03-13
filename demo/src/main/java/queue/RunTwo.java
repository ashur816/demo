package queue;

/**
 * @ClassName: RunOne
 * @Description: 从队列中取出数据
 * @author ZXY
 * @date 2016/8/2 17:01
 */
public class RunTwo implements Runnable {

    @Override
    public void run() {
        QueuePool queuePool = QueuePool.getInstance();
        try {
            while (true) {
                System.out.println(queuePool.getOne());
                Thread.sleep(1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
