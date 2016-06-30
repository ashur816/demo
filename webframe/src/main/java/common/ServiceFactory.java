package common;

import java.lang.reflect.Constructor;

/**
 * Created by Martin on 2015/8/12.
 */
public final class ServiceFactory {

    public static Object getService(Class interfaceClass) throws Exception {
        String svName = interfaceClass.getName();
        Object rtn = null;
        if (svName.lastIndexOf("SV") != -1 || svName.lastIndexOf("DAO") != -1) {
            String[] s = svName.split("\\.");
            int len = s.length;
            String implName = s[0] + "." + s[len - 1].substring(1) + "Impl";
            Class clazz = Class.forName(implName);
            Constructor cons = clazz.getConstructor();
            rtn = cons.newInstance();
        }
        return rtn;
    }
}
