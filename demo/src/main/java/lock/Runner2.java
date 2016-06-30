package lock;

/**
 * Created by Martin on 2015/11/24.
 */
public class Runner2 implements Runnable {

    @Override
    public void run() {
        try {
            synchronized (RunnerMain.map) {
                System.out.println(RunnerMain.getValue(1));
            }
        } catch (Exception e) {

        }
    }
}
