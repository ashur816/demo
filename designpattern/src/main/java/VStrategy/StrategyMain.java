package VStrategy;

/**
 * @author ZXY
 * @ClassName: StrategyMain
 * @Description:
 * @date 2017/4/5 14:27
 */
class StrategyMain {

    public static void main(String[] args) {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0;
        double currentPrice;

        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println("---------------------------------");

        Discount discount;
        discount = new VIPDiscount();
        mt.setDiscount(discount); //注入折扣对象

        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
    }
}
