package EPrototype;

/**
 * @ClassName: Clicent
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZXY
 * @date 2016/6/14 13:16
 */
public class Client {

    public static void main(String[] args) {
//        Prototype obj1 = new ConcretePrototype();
//        obj1.setAttr("moon");
//        Prototype obj2 = obj1.clone();
//
//        System.out.println(obj2.getAttr());
//        System.out.println(obj1==obj2);
//        System.out.println(obj1.getAttr()==obj2.getAttr());

        Product product = new Product();
        product.setAttr("asdasd");

        Product p = product.clone();

    }
}
