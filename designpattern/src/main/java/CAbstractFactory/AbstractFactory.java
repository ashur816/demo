package CAbstractFactory;

/**
 * @ClassName: AbstractFactory
 * @Description: 虚拟工厂
 * @author ZXY
 * @date 2016/5/16 16:30
 */
interface AbstractFactory {

    AbstractProductA createProductA();

    AbstractProductB createProductB();
}
