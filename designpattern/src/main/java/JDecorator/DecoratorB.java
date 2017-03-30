package JDecorator;

/**
 * @author ZXY
 * @ClassName: ConcreteDecoratorA
 * @Description: 具体装饰类
 * @date 2017/3/30 10:52
 */
class DecoratorB extends Decorator{

    public DecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("装饰2");
        super.operation();
    }
}
