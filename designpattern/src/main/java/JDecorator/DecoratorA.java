package JDecorator;

/**
 * @author ZXY
 * @ClassName: ConcreteDecoratorA
 * @Description: 具体装饰类
 * @date 2017/3/30 10:52
 */
class DecoratorA extends Decorator{

    public DecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("装饰1");
        super.operation();
    }
}
