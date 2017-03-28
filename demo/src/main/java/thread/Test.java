package thread;

import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZXY
 * @ClassName: Test
 * @Description:
 * @date 2017/3/27 10:22
 */
public class Test {

    public static void main(String[] args) throws Exception {
        final AtomicAccount account = new AtomicAccount();
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

class AtomicAccount {

    private final AtomicT amount = new AtomicT(0);

    public int getAmount() {
        return amount.get();
    }

    public void increase() {
        amount.addAndGet(1);
    }
}


class AtomicT {
    private static final long valueOffset;

    private volatile int value;

    private static final UnA unA = UnA.getUnA();

    static {
        try {
            valueOffset = unA.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
            System.out.println(valueOffset);
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    public AtomicT(int initValue) {
        this.value = initValue;
    }

    public final int get() {
        return value;
    }

    public final int addAndGet(int delta) {
        for (; ; ) {
            int current = get();
            int next = current + delta;
            if (compareAndSet(current, next))
                return next;
        }
    }

    public final boolean compareAndSet(int expect, int update) {
        return unA.compareAndSwapInt(this, valueOffset, expect, update);
    }
}

final class UnA {

    private static final UnA theUnA;

    private static native void registerNatives();

    public native long objectFieldOffset(Field var1);

    public static UnA getUnA() {
        Class var0 = Reflection.getCallerClass(2);
        if (var0.getClassLoader() != null) {
            throw new SecurityException("UnA");
        } else {
            return theUnA;
        }
    }

    public final native boolean compareAndSwapInt(Object var1, long var2, int var4, int var5);

    static {
        registerNatives();
        Reflection.registerMethodsToFilter(UnA.class, new String[]{"getUnA"});
        theUnA = new UnA();
    }
}
