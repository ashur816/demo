package CAbstractFactory;

/**
 * @ClassName: ConcreteFactory
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZXY
 * @date 2016/5/16 16:30
 */
class FactoryM implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
