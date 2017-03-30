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
        Handler handlerC = new ConcreteHandlerC();
        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);

        handlerA.handleRequest("a");
    }
}
