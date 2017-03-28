package thread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZXY
 * @ClassName: ThreadArrayCopy
 * @Description:
 * @date 2017/3/27 16:08
 */
public class ThreadArrayCopy {

    public static void main(String[] args) {
//        final List list = new ArrayList<>();
        final List list = new CopyOnWriteArrayList();

        ExecutorService exe = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            exe.execute(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 10000; ++i) {
                        list.add(Math.random());
                    }
                }
            });
        }
        exe.shutdown();
    }
}

