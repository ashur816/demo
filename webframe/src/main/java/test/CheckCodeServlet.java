package test; /**
 * Created by Martin on 2015/7/16.
 */

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class CheckCodeServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(CheckCodeServlet.class);


    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");//生成一个消息头  告诉浏览器返回的是j p g格式的图片。
        // 图片的内存映像
        BufferedImage image = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
        Random r = new Random();
        // 获得画笔对象
        Graphics g = image.getGraphics();
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.fillRect(0, 0, 60, 20);
        g.setColor(new Color(0, 0, 0));
        String number = String.valueOf(r.nextInt(99999));
        HttpSession session = request.getSession();
        session.setAttribute("number", number);
        System.out.println(number);
        g.drawString(number, 5, 15);
        g.drawLine(r.nextInt(60), r.nextInt(20), r.nextInt(60), r.nextInt(20));
        // 压缩成jpeg格式
        OutputStream os = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
        // 把BufferedImage对象中的图像信息编码后
        // 向创建该对象(encoder)时指定的输出流输出
        encoder.encode(image);
    }

}
