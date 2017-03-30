package HBrige;

/**
 * @author ZXY
 * @ClassName: Pen
 * @Description:
 * @date 2017/3/28 15:22
 */
abstract class Pen {

    protected Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void paint();
}
