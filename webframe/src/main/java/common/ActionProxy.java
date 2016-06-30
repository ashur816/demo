package common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Martin on 2015/8/7.
 */
public class ActionProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("ActionProxy:invoke");
        return null;
    }
}
