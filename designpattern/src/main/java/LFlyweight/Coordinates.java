package LFlyweight;

/**
 * @author ZXY
 * @ClassName: Coordinates
 * @Description: 坐标类：外部状态类
 * @date 2017/3/30 14:22
 */
class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
