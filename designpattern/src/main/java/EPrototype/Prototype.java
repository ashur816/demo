package EPrototype;

/**
 * @ClassName: Protopyte
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZXY
 * @date 2016/6/14 13:17
 */
public interface Prototype {

    void setAttr(String attr);

    String getAttr();

    Prototype clone();

}
