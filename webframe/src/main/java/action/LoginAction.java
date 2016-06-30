package action;

import common.BaseAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Martin on 2015/8/14.
 */
public class LoginAction  extends BaseAction {
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        //解决乱码
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        if(userName.equals("zhang")&&password.equals("1212")){
            response.getWriter().write("[{'a':'true','m':'登陆成功！'}]");
//            response.getWriter().write("<xml><root><a>true</a><m>登陆成功！</m></root></xml>");
        }
        else {
            response.getWriter().write("[{'a':'true','m':'登陆成功！'}]");
//            response.getWriter().write("<xml><root><a>false</a><m>登陆失败！</m></root></xml>");
        }
    }
}
