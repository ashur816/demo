package UState;

/**
 * @author ZXY
 * @ClassName: StateMain
 * @Description:
 * @date 2017/4/1 15:33
 */
class StateMain {

    public static void main(String[] args) throws Exception {
        Account acc = new Account("段誉", 0.0);
        acc.deposit(1000);
        acc.withdraw(2000);
        acc.deposit(3000);
        acc.withdraw(5000);
        acc.withdraw(1000);
        acc.computeInterest();
    }
}
