package zRubbish;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Martin on 2016/6/19.
 */
public class QianKa {

    private static String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11D257 Safari/9537.53";
    private static String QKAuth = "54245423-CBF3-4FB0-96C1-F5F9D1576F10|cee7dd90-c209-404b-956e-01ca6584d3d8|2386985548011964192";
    private static String QKApp = "iPhone4,1|1047.250000|com.a4.app|3.1.2016051901";
    private static String QKScheme = "com.a4.app";
    private static String QKApiKey = "c26007f41f472932454ea80deabd612c";

    private static void doGet(String url, String qryParam, Map<String, String> map) {
        String result = "";// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        StringBuffer sb = new StringBuffer();// 存储参数

        try {
            URL connURL = new URL(url);
            HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL.openConnection();

            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent", userAgent);

            httpConn.setRequestProperty("X-QK-AUTH", QKAuth);
            httpConn.setRequestProperty("X-QK-APPV", QKApp);
            httpConn.setRequestProperty("X-QK-SCHEME", QKScheme);
            httpConn.setRequestProperty("X-QK-API-KEY", QKApiKey);
            httpConn.setRequestProperty("Access-Control-Allow-Headers", "X-Qk-Auth, *");
            httpConn.setRequestProperty("X-QK-SIGN", map.get("sign"));
            httpConn.setRequestProperty("X-QK-TIME", map.get("time"));

            // 建立实际的连接
            httpConn.connect();
            // 响应头部获取
            Map<String, List<String>> headers = httpConn.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : headers.keySet()) {
                System.out.println(key + "\t：\t" + headers.get(key));
            }
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void doPost(String url, String qryParam, Map<String, String> map) {

        String result = "";// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        PrintWriter out = null;
        StringBuffer sb = new StringBuffer();// 存储参数

        try {
            URL connURL = new URL(url);
            HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL.openConnection();

            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent", userAgent);

            httpConn.setRequestProperty("X-QK-AUTH", QKAuth);
            httpConn.setRequestProperty("X-QK-APPV", QKApp);
            httpConn.setRequestProperty("X-QK-SCHEME", QKScheme);
            httpConn.setRequestProperty("X-QK-API-KEY", QKApiKey);
            httpConn.setRequestProperty("Access-Control-Allow-Headers", "X-Qk-Auth, *");

            httpConn.setRequestProperty("X-QK-SIGN", map.get("sign"));
            httpConn.setRequestProperty("X-QK-TIME", map.get("time"));

            // 设置POST方式
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            // 获取HttpURLConnection对象对应的输出流
            out = new PrintWriter(httpConn.getOutputStream());
            // 发送请求参数
            out.write(qryParam);
            // flush输出流的缓冲
            out.flush();

            // 建立实际的连接
            httpConn.connect();
            // 响应头部获取
            Map<String, List<String>> headers = httpConn.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : headers.keySet()) {
                System.out.println(key + "\t：\t" + headers.get(key));
            }
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn
                    .getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.out.println(result);
        } catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("sign", "1787DC9BC46075204B5FFE14AD142272");
        map.put("time", "1466343368");
        QianKa.doGet("http://qianka.com/services/subtasks.getList", "", map);
    }

}
