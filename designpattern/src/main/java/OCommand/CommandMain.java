package OCommand;

/**
 * @author ZXY
 * @ClassName: CommandMain
 * @Description:
 * @date 2017/3/30 16:51
 */
public class CommandMain {

    public static void main(String[] args) {
        Command commandA = new ConcreteCommandB();
        Command commandB = new ConcreteCommandA();

        Invoker invoker1 = new Invoker(commandA);
        invoker1.call();

        Invoker invoker2 = new Invoker(commandB);
        invoker2.call();
    }
}
