package BFactoryMethod;

/**
 * @ClassName: Client
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZXY
 * @date 2016/5/17 13:08
 */
class Client {

    public static void main(String[] args) {

        AbstractFactory abstractFactory = new FactoryB();
        AbstractProduct product = abstractFactory.createProduct();
        product.getProduct();
    }
}
