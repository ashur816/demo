package action;

import common.BaseAction;
import common.ServiceFactory;
import service.IStudySV;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Martin on 2015/7/16.
 */
public class CookiesAction extends BaseAction {

    public void aa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>aa");
        IStudySV sv = (IStudySV) ServiceFactory.getService(IStudySV.class);
        sv.getId();
        response.getWriter().print("[{'A':'12','B':'14'}]");
    }

    public void bb(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("bb");
    }

    @Override
    /**
     * 没有 load-on-startup 配置，不会被调用
     */
    public void init() throws ServletException {
        System.out.println("CookiesAction:init");
    }
}
