package NResponChain;

/**
 * @author ZXY
 * @ClassName: ConcreteHandlerA
 * @Description:
 * @date 2017/3/30 15:38
 */
class ConcreteHandlerA extends Handler {
    @Override
    public void handleRequest(String request) {
        System.out.println("aaa");
        if ("a".equals(request)) {
            successor.handleRequest(request);
        }
    }
}
