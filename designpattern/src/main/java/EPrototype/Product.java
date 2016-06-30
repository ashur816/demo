package EPrototype;

/**
 * @ClassName: Product
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZXY
 * @date 2016/6/14 14:24
 */
public class Product implements Cloneable {

    private String attr;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public Product clone() {
        Object obj = null;
        try {
            obj = super.clone();
            return (Product) obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制！");
            return null;
        }
    }
}
