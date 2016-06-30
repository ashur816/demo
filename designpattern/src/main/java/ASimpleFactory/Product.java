package ASimpleFactory;

/**
 * @ClassName: Product
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZXY
 * @date 2016/5/17 10:52
 */
abstract class Product {

    public void methodSame(){
        //公共的
        System.out.println("same");
    }

    public abstract void methodDiff();
}
