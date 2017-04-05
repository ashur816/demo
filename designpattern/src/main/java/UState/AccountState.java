package UState;

/**
 * @author ZXY
 * @ClassName: AccountState
 * @Description: 抽象状态类
 * @date 2017/4/1 15:28
 */
abstract class AccountState {
    protected Account acc;

    public abstract void deposit(double amount) throws Exception;

    public abstract void withdraw(double amount) throws Exception;

    public abstract void computeInterest();

    public abstract void stateCheck(double curBalance) throws Exception;
}
