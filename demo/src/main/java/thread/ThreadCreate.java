package thread;

/**
 * Created by Martin on 2015/11/24.
 */
class ThreadCreate {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();

        t2.run();
    }
}

class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println("11");
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("22");
    }
}
