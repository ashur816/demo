package volatileDemo;

/**
 * Created by Martin on 2015/11/25.
 */
public class voTest {
    static int count = 0;

    public static void inc() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 1000; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        inc();
                    }
                }).start();
            }

            Thread.sleep(1000l);
            System.out.println("count="+count);
        } catch (Exception e) {

        }
    }
}
