package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZXY
 * @ClassName: ThreadAtomic
 * @Description: 原子操作 很快
 * @date 2017/3/24 16:39
 */
public class ThreadAtomic {

    public static void main(String[] args) throws Exception {
        final Account account = new Account();
        ExecutorService exe = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 10000000; i++) {
            exe.execute(new Runnable() {
                @Override
                public void run() {
                    account.increase();
                }
            });
        }
        exe.shutdown();
        while (true) {
            if (exe.isTerminated()) {
                System.out.println("结束了！" + account.getAmount());
                break;
            }
            Thread.sleep(200);
        }
    }
}

class Account {

    private final AtomicInteger amount = new AtomicInteger(0);

    public int getAmount() {
        return amount.get();
    }

    public void increase() {
        amount.addAndGet(1);
    }
}
