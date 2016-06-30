package test;

/**
 * Created by Martin on 2015/7/16.
 */
public class MultiThreadDemo {

    public static void main(String[] args) {
        MultiThread m1 = new MultiThread("Old");
        MultiThread m2 = new MultiThread("Children");
        MultiThread m3 = new MultiThread("Young");
        m1.start();
        m2.start();
        m3.start();
    }
}

class MultiThread extends Thread {
    private  int tickets = 100;

    MultiThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (tickets > 0) {
            System.out.println("Thread[" + Thread.currentThread().getName() + "],soldNum:" + tickets--);
        }
    }
}
