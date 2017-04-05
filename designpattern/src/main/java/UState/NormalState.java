package UState;

/**
 * @author ZXY
 * @ClassName: NormalState
 * @Description: 具体状态类 -- 正常状态
 * @date 2017/4/1 15:28
 */
class NormalState extends AccountState {

    double curBalance = 0;

    public NormalState(Account acc) {
        this.acc = acc;
    }

    public NormalState(AccountState state) {
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
        System.out.println("正常状态，无须支付利息！");
    }

    //状态转换
    public void stateCheck(double curBalance) throws Exception {
        if (curBalance > -2000 && curBalance <= 0) {
            acc.setState(new OverdraftState(this));
        } else if (curBalance == -2000) {
            acc.setState(new RestrictedState(this));
        } else if (curBalance < -2000) {
            throw new Exception("操作受限！");
        }
    }
}
