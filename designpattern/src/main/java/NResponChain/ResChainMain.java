package NResponChain;

/**
 * @author ZXY
 * @ClassName: ResponChain
 * @Description:
 * @date 2017/3/30 15:40
 */
class ResChainMain {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        handlerA.setSuccessor(handlerB);

        handlerA.handleRequest("a");

    }
}
