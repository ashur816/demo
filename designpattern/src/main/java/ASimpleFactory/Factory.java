package ASimpleFactory;

/**
 * @ClassName: Factory
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZXY
 * @date 2016/5/17 10:51
 */
class Factory {

    public Product getProduct(String type){
        Product p = null;
        if("a".equals(type)){
            p = new ProductA();
        }
        else if("b".equals(type)){
            p = new ProductB();
        }
        return p;
    }
}
