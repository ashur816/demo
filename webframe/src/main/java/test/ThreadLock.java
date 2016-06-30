package test;

/**
 * Created by Martin on 2015/7/16.
 * �߳�ͬ��������Ԥ����˳��ִ��
 * <p/>
 * �����̵߳�ͬ����һ�������½��������
 * 1. ����Ҫͬ���ķ����ķ���ǩ���м���synchronized�ؼ��֡�
 * 2. ʹ��synchronized�����Ҫ����ͬ���Ĵ���ν���ͬ����
 * 3. ʹ��JDK 5���ṩ��java.util.concurrent.lock���е�Lock����
 * <p/>
 * ��������ȷ����ͬ�������ַ�ʽ��ͬ�����ͬ��������Ϊʲôû��wait��notify������һ��ڲ����½�������������
 * �����ͬ������飬���������Ҫ�����Ա�Լ�ָ����һ����Щ����Ϊsynchronized(this)ֻ���ڵ���ģʽ����Ч�������ʵ������ֻ��һ����
 * �����ͬ����������־�̬�ͷǾ�̬���� ��
 * ��̬������һ����ͬ�����Ǿ�̬�������ڵ���ģʽ����Ч���Ƽ��þ�̬����(���õ����Ƿ���)
 */
public class ThreadLock {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new LockThread1(i).start();
//            new LockThread2(i,"2").start();
        }
    }
}

/*
 * �����ӹؼ���synchronized
 * ͬ����̬���������������Ǹþ�̬�������ڵ����Classʵ��
 */
class LockThread1 extends Thread {
    private int threadNo;

    LockThread1(int threadNo) {
        this.threadNo = threadNo;
    }

    public static synchronized void lock(int threadNo) {
        for (int i = 0; i < 100; i++) {
            System.out.println("thread[" + threadNo + "],number[" + i + "]");
        }
    }

    @Override
    public void run() {
        lock(threadNo);
    }
}

/*
 * ʹ��synchronized�����
 * ���ͬ����Ķ����������� main�����д������Ǹ�String����
 */
class LockThread2 extends Thread {
    private int    threadNo;
    private String lock;

    LockThread2(int threadNo, String lock) {
        this.threadNo = threadNo;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 100; i++) {
                System.out.println("thread[" + threadNo + "],number[" + i + "]");
            }
        }
    }
}