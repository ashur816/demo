package lock;

/**
 * Created by Martin on 2015/11/24.
 */
public class Runner1 implements Runnable {

    @Override
    public void run() {
        try{
            synchronized (RunnerMain.map) {
                System.out.println(RunnerMain.getValue(1));
                Thread.sleep(5000l);
                System.out.println("s");
            }
        }
        catch (Exception e){

        }
    }

}
