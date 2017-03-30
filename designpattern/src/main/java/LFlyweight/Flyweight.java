package LFlyweight;

/**
 * @author ZXY
 * @ClassName: Flyweight
 * @Description:
 * @date 2017/3/30 13:48
 */
abstract class Flyweight {

    public abstract String getColor();

    public void display(Coordinates coordinates) {
        System.out.println("棋子颜色" + getColor() + "-X:" + coordinates.getX() + ",Y:" + coordinates.getY());
    }
}
