package IComposite;

/**
 * @author ZXY
 * @ClassName: CompositeMain
 * @Description:
 * @date 2017/3/30 10:06
 */
class CompositeMain {

    public static void main(String[] args) {
        Composite composite = new Composite();

        Component com1 = new Leaf();
        composite.add(com1);

        //新对象，内部list为空，除非再加子节点
        Component com2 = new Composite();
        composite.add(com2);

        composite.operation();
    }
}
