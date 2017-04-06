package VStrategy;

/**
 * @author ZXY
 * @ClassName: StudentDiscount
 * @Description: 学生票折扣类：具体策略类
 * @date 2017/4/5 14:24
 */
class StudentDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("学生票");
        return price * 0.8;
    }
}
