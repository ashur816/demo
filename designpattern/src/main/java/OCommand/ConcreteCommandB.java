package OCommand;

/**
 * @author ZXY
 * @ClassName: ConcreteCommand
 * @Description: 具体命令类
 * @date 2017/3/30 16:44
 */
class ConcreteCommandB extends Command{
    private HandlerB handlerB; //维持一个对请求接收者对象的引用

    public ConcreteCommandB(){
        this.handlerB = new HandlerB();
    }

    @Override
    public void execute() {
        handlerB.minimize();
    }
}
