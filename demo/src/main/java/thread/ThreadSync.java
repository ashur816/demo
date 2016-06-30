package thread;

/**
 * Created by Martin on 2015/11/24.
 * �����̵߳�ͬ����һ�������½��������
 * 1. ����Ҫͬ���ķ����ķ���ǩ���м���synchronized�ؼ��֡�
 * 2. ʹ��synchronized�����Ҫ����ͬ���Ĵ���ν���ͬ����
 * 3. ʹ��JDK 5���ṩ��java.util.concurrent.lock���е�Lock����
 * <p/>
 * ����������ͬ�������ַ�ʽ��ͬ�����ͬ��������Ϊʲôû��wait��notify������һ��ڲ����½�������������
 * �����ͬ������飬���������Ҫ�����Ա�Լ�ָ����һ����Щ����Ϊsynchronized(this)ֻ���ڵ���ģʽ����Ч�������ʵ������ֻ��һ����
 * �����ͬ����������־�̬�ͷǾ�̬���� ��
 * ��̬������һ����ͬ�����Ǿ�̬�������ڵ���ģʽ����Ч���Ƽ��þ�̬����(���õ����Ƿ���)
 */
public class ThreadSync {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new ThreadSync1(i).start();
//            new LockThread2(i,"2").start();
        }
    }
}
