package thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZXY
 * @ClassName: ThreadConcurrentMap
 * @Description:
 * @date 2017/3/27 14:09
 */
public class ThreadConcurrentMap {

    public static void main(String[] args) throws Exception {
        final Consumer consumer = new Consumer();

        ExecutorService exe = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 30; i++) {
            final int j = i;
            exe.execute(new Runnable() {
                @Override
                public void run() {
                    if (j % 3 == 0) {
                        consumer.decrease("a");
                    } else if (j % 3 == 1) {
                        consumer.decrease("b");
                    } else {
                        consumer.decrease("c");
                    }
                }
            });
        }
        exe.shutdown();
        while (true) {
            if (exe.isTerminated()) {
                System.out.println("结束了！");
                System.out.println("a=" + consumer.getMap().get("a"));
                System.out.println("b=" + consumer.getMap().get("b"));
                System.out.println("c=" + consumer.getMap().get("c"));
                break;
            }
            Thread.sleep(200);
        }
    }
}

class Consumer {

    static Map<String, Integer> cMap = new ConcurrentHashMap();

    static {
        cMap.put("a", 10);
        cMap.put("b", 10);
        cMap.put("c", 10);
    }

    public Map<String, Integer> getMap() {
        return cMap;
    }

    public void decrease(String key) {
        int count = cMap.get(key);
        count--;
        cMap.put(key, count);
        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
