package EPrototype;

/**
 * @ClassName: Clicent
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZXY
 * @date 2016/6/14 13:16
 */
class Client {

    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype();
        prototype.setAttr("moon");
        Prototype obj2 = prototype.clone();

        System.out.println(obj2.getAttr());
        System.out.println(prototype == obj2);
        System.out.println(prototype.getAttr() == obj2.getAttr());

//        Product product = new Product();
//        product.setAttr("asdasd");
//
//        Product p = product.clone();

    }
}
