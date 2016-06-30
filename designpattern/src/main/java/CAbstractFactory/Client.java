package CAbstractFactory;

/**
 * @ClassName: abFactoryTest
 * @Description: 提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式又称为Kit模式，它是一种对象创建型模式。
 * A1+B1组合成一种 A2+B2组合成另一种
 * @author ZXY
 * @date 2016/5/17 10:22
 */
public class Client {

    public static void main(String[] args) {
        AbstractFactory factory = new FactoryN();
        AbstractProductA a = factory.createProductA();
        AbstractProductB b = factory.createProductB();

        a.createProductA();
        b.createProductB();
    }
}
