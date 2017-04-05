package UState;

/**
 * @author ZXY
 * @ClassName: NormalState
 * @Description: 具体状态类 -- 透支状态
 * @date 2017/4/1 15:28
 */
class OverdraftState extends AccountState{
    double curBalance = 0;
    public OverdraftState(AccountState state) {
        this.acc = state.acc;
    }

    public void deposit(double amount) throws Exception {
        curBalance = acc.getBalance() + amount;
        stateCheck(curBalance);
        acc.setBalance(curBalance);
    }

    public void withdraw(double amount) throws Exception {
        curBalance = acc.getBalance() - amount;
        stateCheck(curBalance);
        acc.setBalance(curBalance);
    }

    public void computeInterest() {
        System.out.println("计算利息！");
    }

    //状态转换
    public void stateCheck(double curBalance)  throws Exception{
        if (curBalance > 0) {
            acc.setState(new NormalState(this));
        }
        else if (curBalance == -2000) {
            acc.setState(new RestrictedState(this));
        }
        else if (curBalance < -2000) {
            throw new Exception("操作受限！");
        }
    }
}
