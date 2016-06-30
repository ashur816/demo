package CAbstractFactory;

/**
 * @ClassName: ConcreteProduct
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZXY
 * @date 2016/5/16 16:31
 */
class ProductB2 implements AbstractProductB{
    @Override
    public void createProductB() {
        System.out.println("This is B2");
    }
}
