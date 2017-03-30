package JDecorator;

/**
 * @author ZXY
 * @ClassName: ConcreteComponent
 * @Description: 具体构件
 * @date 2017/3/30 10:48
 */
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("真执行");
    }
}
