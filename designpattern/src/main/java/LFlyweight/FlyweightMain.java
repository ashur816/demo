package LFlyweight;

/**
 * @author ZXY
 * @ClassName: FlyweightMain
 * @Description:
 * @date 2017/3/30 14:04
 */
class FlyweightMain {

    public static void main(String[] args) {
        Flyweight f1, f2, f3;
        FlyweightFactory factory = FlyweightFactory.getInstance();
        f1 = factory.getFlyweight("b");
        f2 = factory.getFlyweight("b");
        f3 = factory.getFlyweight("b");
        System.out.println("判断两颗黑子是否相同：" + (f1 == f2));
        f3.display(new Coordinates(1, 2));
    }
}
