package ASimpleFactory;

/**
 * @ClassName: Client
 * @Description:
 * @author ZXY
 * @date 2016/5/17 10:56
 */
class Client {

    public static void main(String[] args) {
        Factory factory = new Factory();
        Product a = factory.getProduct("a");
        a.methodSame();
        a.methodDiff();
    }
}
