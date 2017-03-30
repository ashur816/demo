package JDecorator;

/**
 * @author ZXY
 * @ClassName: DecoratorMain
 * @Description:
 * @date 2017/3/30 10:58
 */
public class DecoratorMain {

    public static void main(String[] args) {
        //可以多次装饰
        Component component1 = new DecoratorA(new ConcreteComponent());
        Component component2 = new DecoratorB(component1);
        component2.operation();

        //只能装饰一次
        HalfDecorator halfDecorator = new HalfDecoratorA(new ConcreteComponent());
        halfDecorator.operation();
    }
}
