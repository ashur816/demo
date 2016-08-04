package queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: QueueUtils
 * @Description: 常见队列
 * @author ZXY
 * @date 2016/8/2 16:44
 */
public class QueuePool {

    public final static BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

    private static class initHold {
        private static QueuePool instance = new QueuePool();
    }

    public static QueuePool getInstance() {
        return initHold.instance;
    }

    public boolean addOne(String s) {
        return blockingQueue.offer(s);
    }

    public String getOne() throws Exception {
        return blockingQueue.poll();
    }

    public String getOne(long timeLen, TimeUnit timeUnit) throws Exception {
        return blockingQueue.poll(timeLen, timeUnit);
    }

    public BlockingQueue<String> getBlockingQueue(){
        return blockingQueue;
    }
}
