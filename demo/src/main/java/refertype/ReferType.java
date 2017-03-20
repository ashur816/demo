package refertype;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author ZXY
 * @ClassName: referType
 * @Description: java引用类型分四种 强 软 弱 虚引用 生命周期依次减少，强引用不会被回收 软引用内存不足回收 弱和虚都会被回收
 * ⑴强引用（StrongReference）
 * 强引用是使用最普遍的引用。如果一个对象具有强引用，那垃圾回收器绝不会回收它。当内存空间不足，Java虚拟机宁愿抛出OutOfMemoryError错误，使程序异常终止，也不会靠随意回收具有强引用的对象来解决内存不足的问题。
 * ps：强引用其实也就是我们平时A a = new A()这个意思。
 * <p>
 * ⑵软引用（SoftReference）
 * 如果一个对象只具有软引用，则内存空间足够，垃圾回收器就不会回收它；如果内存空间不足了，就会回收这些对象的内存。只要垃圾回收器没有回收它，该对象就可以被程序使用。软引用可用来实现内存敏感的高速缓存（下文给出示例）
 * <p>
 * 软引用可以和一个引用队列（ReferenceQueue）联合使用，如果软引用所引用的对象被垃圾回收器回收，Java虚拟机就会把这个软引用加入到与之关联的引用队列中。
 * <p>
 * ⑶弱引用（WeakReference）
 * 弱引用与软引用的区别在于：只具有弱引用的对象拥有更短暂的生命周期。在垃圾回收器线程扫描它所管辖的内存区域的过程中，一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。
 * 不过，由于垃圾回收器是一个优先级很低的线程，因此不一定会很快发现那些只具有弱引用的对象。
 * 弱引用可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所引用的对象被垃圾回收，Java虚拟机就会把这个弱引用加入到与之关联的引用队列中。
 * <p>
 * ⑷虚引用（PhantomReference）
 * “虚引用”顾名思义，就是形同虚设，与其他几种引用都不同，虚引用并不会决定对象的生命周期。如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收器回收。
 * 虚引用主要用来跟踪对象被垃圾回收器回收的活动。虚引用与软引用和弱引用的一个区别在于：虚引用必须和引用队列 （ReferenceQueue）联合使用。当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，
 * 就会在回收对象的内存之前，把这个虚引用加入到与之 关联的引用队列中。
 * @date 2017/3/16 13:47
 */
public class ReferType {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static void main(String[] args) {
        //创建一个强引用
        String str = "hello";
        //创建引用队列, <String>为范型标记，表明队列中存放String对象的引用
        ReferenceQueue<String> rq = new ReferenceQueue<>();
        //创建一个弱引用，它引用"hello"对象，并且与rq引用队列关联
        //<String>为范型标记，表明WeakReference会弱引用String对象
        WeakReference<String> wf = new WeakReference<>(str, rq);

        str = null; //④取消"hello"对象的强引用

        //两次催促垃圾回收器工作，提高"hello"对象被回收的可能性
        System.gc(); //⑤
        System.gc(); //⑥

        String str1 = wf.get(); //⑤假如"hello"对象没有被回收，str1引用"hello"对象
        //假如"hello"对象没有被回收，rq.poll()返回null
        Reference<? extends String> ref = rq.poll(); //⑥
    }

}
