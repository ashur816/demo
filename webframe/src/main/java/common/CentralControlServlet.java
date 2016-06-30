package common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Martin on 2015/8/8.
 */
public class CentralControlServlet extends HttpServlet {
    RequestProcessor rp = new RequestProcessor();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            rp.process(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
