package IComposite;

import java.util.ArrayList;

/**
 * @author ZXY
 * @ClassName: Composite
 * @Description: 容器构件
 * @date 2017/3/30 10:04
 */
class Composite extends Component {
    private ArrayList<Component> list = new ArrayList<>();

//    @Override
    public void add(Component c) {
        list.add(c);
    }

//    @Override
    public void remove(Component c) {
        list.remove(c);
    }

//    @Override
    public Component getChild(int i) {
        return list.get(i);
    }

    @Override
    public void operation() {
        //容器构件具体业务方法的实现
        //递归调用成员构件的业务方法
        for (Object obj : list) {
            ((Component) obj).operation();
        }
    }
}
