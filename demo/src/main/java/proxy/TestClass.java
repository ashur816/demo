package proxy;

/**
 * Created by Martin on 2015/11/25.
 */
public class TestClass implements TargetInterface {

    @Override
    public int targetMethodA(int num) {
        System.out.println(num);
        return num;
    }

    @Override
    public int targetMethodB(int num) {
        System.out.println(num);
        return num;
    }
}
