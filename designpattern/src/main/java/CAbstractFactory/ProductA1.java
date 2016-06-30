package CAbstractFactory;

/**
 * @ClassName: ConcreteProduct
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZXY
 * @date 2016/5/16 16:31
 */
class ProductA1 implements AbstractProductA {
    @Override
    public void createProductA() {
        System.out.println("This is A1");
    }
}
