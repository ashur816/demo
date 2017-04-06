package VStrategy;

/**
 * @author ZXY
 * @ClassName: ChildrenDiscount
 * @Description:
 * @date 2017/4/5 14:25
 */
class ChildrenDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("儿童票");
        return price - 10;
    }
}
