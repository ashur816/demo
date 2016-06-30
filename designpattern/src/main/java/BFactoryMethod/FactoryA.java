package BFactoryMethod;

/**
 * @ClassName: ConcreteFactoryA
 * @Description: 具体工厂A
 * @author ZXY
 * @date 2016/5/17 11:18
 */
class FactoryA implements AbstractFactory {

    @Override
    public AbstractProduct createProduct() {
        return new ProductA();
    }
}
