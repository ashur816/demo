package EPrototype;

/**
 * @ClassName: ConcretePrototypeA
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZXY
 * @date 2016/6/14 13:19
 */
class ConcretePrototype implements Prototype {

    private String attr;

    @Override
    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public String getAttr() {
        return attr;
    }

    @Override
    public Prototype clone() {
        Prototype prototype = new ConcretePrototype();
        prototype.setAttr(this.attr);
        return prototype;
    }
}
