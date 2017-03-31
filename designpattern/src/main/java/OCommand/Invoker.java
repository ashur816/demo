package OCommand;

/**
 * @author ZXY
 * @ClassName: Invoker
 * @Description: 调用者，请求发送者
 * @date 2017/3/30 16:44
 */
class Invoker {

    private Command command;

    //构造注入
    public Invoker(Command command) {
        this.command = command;
    }

    //设值注入
    public void setCommand(Command command) {
        this.command = command;
    }

    //业务方法，用于调用命令类的execute()方法
    public void call() {
        command.execute();
    }
}
