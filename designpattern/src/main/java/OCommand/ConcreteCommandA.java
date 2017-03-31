package OCommand;

/**
 * @author ZXY
 * @ClassName: ConcreteCommand
 * @Description: 具体命令类
 * @date 2017/3/30 16:44
 */
class ConcreteCommandA extends Command {
    private HandlerA handlerA; //维持一个对请求接收者对象的引用

    public ConcreteCommandA() {
        this.handlerA = new HandlerA();
    }

    @Override
    public void execute() {
        handlerA.display();
    }
}
