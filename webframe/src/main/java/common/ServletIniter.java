package common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by Martin on 2015/8/8.
 */
public class ServletIniter extends HttpServlet {

    @Override
    /**
     * 有 load-on-startup 配置，默认会被调用
     */
    public void init() throws ServletException {
        System.out.println("ServletIniter:init");
    }
}
