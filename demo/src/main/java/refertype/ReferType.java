package refertype;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author ZXY
 * @ClassName: referType
 * @Description:
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
