package VStrategy;

/**
 * @author ZXY
 * @ClassName: VIPDiscount
 * @Description:
 * @date 2017/4/5 14:26
 */
class VIPDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("VIP票");
        System.out.println("增加积分！");
        return price * 0.5;
    }
}
