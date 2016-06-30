package BFactoryMethod;

/**
 * @ClassName: ConcreteProductA
 * @Description: 具体产品A
 * @author ZXY
 * @date 2016/5/17 11:16
 */
class ProductA implements AbstractProduct {

    @Override
    public void getProduct() {
        System.out.println("product-A");
    }
}
