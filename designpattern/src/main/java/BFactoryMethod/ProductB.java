package BFactoryMethod;

/**
 * @ClassName: ConcreteProductB
 * @Description: 具体产品B
 * @author ZXY
 * @date 2016/5/17 11:17
 */
class ProductB implements AbstractProduct {
    @Override
    public void getProduct() {
        System.out.println("product-B");
    }
}
