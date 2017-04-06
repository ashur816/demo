package VStrategy;

/**
 * @author ZXY
 * @ClassName: MovieTicket
 * @Description: 电影票类：环境类
 * @date 2017/4/5 14:24
 */
class MovieTicket {

    private double price;

    private Discount discount;

    public double getPrice() {
        return discount.calculate(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
