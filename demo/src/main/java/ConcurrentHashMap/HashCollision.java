package ConcurrentHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZXY
 * @ClassName: HashCollision
 * @Description: Hash碰撞
 * @date 2017/3/20 10:24
 */
public class HashCollision {

    public static void main(String[] args) {
        Map map = new HashMap();

        map.put("1", "t1");
        map.put("2", "t2"); //“2”的hashcode=50

        Obj obj = new Obj(1);
        map.put(obj, "87878");

        map.put("2", "55"); //“2”的hashcode=50

        System.out.println(map.size());
        System.out.println("2".hashCode());
        System.out.println(obj.hashCode());

        Obj obj1 = new Obj(2);
        System.out.println(obj1.hashCode());
        System.out.println(map.get(obj1));

        for (Object aEntry : map.entrySet()) {
            Map.Entry entry = (Map.Entry) aEntry;
            System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
        }
    }

}

class Obj {

    private int k;

    public Obj(int key) {
        this.k = key;
    }

    @Override
    public int hashCode() {
        return 50;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
