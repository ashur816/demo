package JDecorator;

/**
 * @author ZXY
 * @ClassName: HalfDecoratorConA
 * @Description:
 * @date 2017/3/30 11:33
 */
class HalfDecoratorA extends HalfDecorator {

    public HalfDecoratorA(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();  //调用原有业务方法
        System.out.println("sss");
    }
}
