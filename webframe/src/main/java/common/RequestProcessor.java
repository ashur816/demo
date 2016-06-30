package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * Created by Martin on 2015/8/7.
 */
public class RequestProcessor {

    protected Class[] types = new Class[]{HttpServletRequest.class, HttpServletResponse.class};

    public RequestProcessor() {
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        HttpSession session = request.getSession();
        String methodName = request.getParameter("action");
        Object[] args = new Object[]{request, response};

        String requestUrl = request.getPathInfo();
        String[] detailUrl = requestUrl.split("/");
        String className = detailUrl[1];

        Class cls = Class.forName(className);
        Method method = cls.getMethod(methodName, this.types);
        method.invoke(cls.newInstance(), args);

//        BaseAction ex = (BaseAction) cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
//        Method method = ex.getClass().getMethod(methodName, this.types);
//        method.invoke(ex, args);

    }

}
