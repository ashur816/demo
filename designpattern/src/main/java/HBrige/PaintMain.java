package HBrige;

/**
 * @author ZXY
 * @ClassName: PaintMain
 * @Description:
 * @date 2017/3/28 15:23
 */
public class PaintMain {

    public static void main(String[] args) {
        Pen pen = new PenOne();
        ColorBlack black = new ColorBlack();
        pen.setColor(black);
        pen.paint();
    }
}
