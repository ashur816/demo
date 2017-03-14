package queue;

/**
 * @author ZXY
 * @ClassName: RunOne
 * @Description: 从队列中取出数据
 * @date 2016/8/2 17:01
 */
public class RunTwo implements Runnable {

    @Override
    public void run() {
        QueuePool queuePool = QueuePool.getInstance();
        try {
            while (true) {
                System.out.println("列头值：" + queuePool.takeOne());
                Thread.sleep(1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
