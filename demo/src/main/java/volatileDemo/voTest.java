package volatileDemo;

/**
 * @param
 * @return
 * @throws
 * @Description: 用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最新值。volatile很容易被误用，用来进行原子性操作。
 * 对于volatile修饰的变量，jvm虚拟机只是保证从主内存加载到线程工作内存的值是最新的
 * <p>
 * 在 java 垃圾回收整理一文中，描述了jvm运行时刻内存的分配。其中有一个内存区域是jvm虚拟机栈，每一个线程运行时都有一个线程栈，
 * 线程栈保存了线程运行时候变量值信息。当线程访问某一个对象时候值的时候，首先通过对象的引用找到对应在堆内存的变量的值，然后把堆内存
 * 变量的具体值load到线程本地内存中，建立一个变量副本，之后线程就不再和对象在堆内存变量值有任何关系，而是直接修改副本变量的值，
 * 在修改完之后的某一个时刻（线程退出之前），自动把线程变量副本的值回写到对象在堆中变量。这样在堆中的对象的值就产生变化了
 * <p>
 * 但是这一些操作并不是原子性，也就是 在read load之后，如果主内存count变量发生修改之后，线程工作内存中的值由于已经加载，不会产生对应的变化，所以计算出来的结果会和预期不一样
 * 对于volatile修饰的变量，jvm虚拟机只是保证从主内存加载到线程工作内存的值是最新的
 */
public class voTest {
    static int count = 0;

    public static void inc() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        count++;
        System.out.println("增长后：" + count);
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
            System.out.println("count=" + count);
        } catch (Exception e) {

        }
    }
}
