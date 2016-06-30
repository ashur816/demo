package BFactoryMethod;

/**
 * @ClassName: ConcreteFactoryA
 * @Description: 具体工厂B
 * @author ZXY
 * @date 2016/5/17 11:18
 */
class FactoryB implements AbstractFactory {

    @Override
    public AbstractProduct createProduct() {
        return new ProductB();
    }
}
