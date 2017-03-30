package JDecorator;

/**
 * @author ZXY
 * @ClassName: Decorator
 * @Description: 抽象装饰类
 * @date 2017/3/30 10:49
 */
abstract class Decorator implements Component {

    private Component component;  //维持一个对抽象构件对象的引用

    public Decorator(Component component) {  //注入一个抽象构件类型的对象
        this.component = component;
    }

    public void operation() {
        component.operation();  //调用原有业务方法
    }
}
