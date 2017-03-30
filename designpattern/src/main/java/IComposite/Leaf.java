package IComposite;

/**
 * @author ZXY
 * @ClassName: Leaf
 * @Description: 叶子构件
 * @date 2017/3/30 10:03
 */
class Leaf extends Component {
//    @Override
//    public void add(Component c) {
//        System.out.println("不能用");
//    }
//
//    @Override
//    public void remove(Component c) {
//        System.out.println("不能用");
//
//    }
//
//    @Override
//    public Component getChild(int i) {
//        System.out.println("不能用");
//        return null;
//    }

    @Override
    public void operation() {
        System.out.println("叶子执行");
    }
}
