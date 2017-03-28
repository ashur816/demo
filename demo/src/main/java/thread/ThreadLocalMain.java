package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZXY
 * @ClassName: ThreadLocalMain
 * @Description: 隔离共享变量
 * @date 2017/3/24 17:12
 */
public class ThreadLocalMain {

    public static void main(String[] args) throws Exception {
        final Acct acct = new Acct();
        ExecutorService exe = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 10; i++) {
            exe.execute(new Runnable() {
                @Override
                public void run() {
                    acct.increase();
                }
            });
        }
        exe.shutdown();
        while (true) {
            if (exe.isTerminated()) {
                System.out.println("结束了！" + acct.getAmount());
                break;
            }
            Thread.sleep(200);
        }
    }

}

class Acct {
    //本地线程变量副本
    private static ThreadLocal<Integer> threadLocalCount = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return 0;
        }
    };

    public int getAmount() {
        return threadLocalCount.get();
    }

    public void increase() {
        for (int i = 0; i < 10; i++) {
            int amount = threadLocalCount.get();
            amount++;
            threadLocalCount.set(amount);
        }
        System.out.println(Thread.currentThread().getId() + "_" + threadLocalCount.get());
    }
}
