package ConcurrentHashMap;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author ZXY
 * @ClassName: HashMapDeadLock
 * @Description:
 * @date 2017/3/17 9:14
 */
public class HashMapDeadLock {

    public static void main(String[] args) throws Exception {
        final HashMap<String, String> map = new HashMap<>(2);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread() + "开始");
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "aaa" + i).start();
                }
            }
        }, "aaa");
        thread.start();
//        thread.join();
    }
}
