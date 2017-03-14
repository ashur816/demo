package queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName: QueueUtils
 * @Description: 阻塞队列
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

    public BlockingQueue<String> getBlockingQueue(){
        return blockingQueue;
    }

    /**
     * @param
     * @return
     * @throws
     * @Description: 添加一个元素并返回true，如果队列已满，则返回false
     */
    public boolean offerOne(String s) {
        return blockingQueue.offer(s);
    }

    /**
     * @param
     * @return
     * @throws
     * @Description: 移除并返问队列头部的元素，如果队列为空，则返回null
     */
    public String pollOne() throws Exception {
        //移除并返问队列头部的元素
        return blockingQueue.poll();
    }

    /**
     * @param
     * @return
     * @throws
     * @Description: 返回队列头部的元素，如果队列为空，则返回null
     */
    public String peekOne() throws Exception {
        //返回队列头部的元素
        return blockingQueue.peek();
    }

    /**
     * @param
     * @return
     * @throws
     * @Description: 添加一个元素，如果队列满，则阻塞
     */
    public void putOne(String s) throws Exception {
        //返回队列头部的元素
        blockingQueue.put(s);
    }

    /**
     * @param
     * @return
     * @throws
     * @Description: 移除并返回队列头部的元素，如果队列为空，则阻塞
     */
    public String takeOne() throws Exception {
        //返回队列头部的元素
        return blockingQueue.take();
    }

}
