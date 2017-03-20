package zRubbish;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AllTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZXY
 * @date 2016/8/3 11:18
 */
public class AllTest {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(null,1);
        map.put(null,5);
        System.out.println(map.hashCode());
    }
}
