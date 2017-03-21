package com.ashur.common;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.OutputStream;


/**
 * Created by Martin on 2015/11/21.
 */
public class QBGrab1 {
    private static String mrb = "1000000";
    private static String mre = "10000000";

    private static String browse = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31";
    private static String pageUrl = "http://www.qbao.com/ntask/home.html?qy=1&co=0&po=0&ti=0&re=0&mar=0&mr=-1&mrb=" + mrb + "&mre=" + mre + "&ty=0&dy=0&dyb=&dye=&searchKey=&p=1&createSource=0&isBq=0&isFl=0&isBus=0&isQb=0#anchor";
    private static String ulClass = "Js-taskLists clearfix";
    private static String taskClass = "taskEve";
    private static String baoquanClass = "taskOther taskQuan clearfix";
    private static String baobiClass = "taskSum";
    private static String aboutClass = "taskAbout";

    private static String TASK_NAME = "task_name";
    private static String TASK_ADDRESS = "task_address";
    private static String Q_REWARD = "q_reward";
    private static String QB_REWARD = "qb_reward";
    private static String CASH_DEPOSIT = "cash_deposit";
    private static String PENAL_SUM = "penal_sum";
    private static String DAYS_COST = "days_cost";
    private static String AVERAGE_REVENUE = "average_revenue";
    private static String AVERAGE_REVENUE_BQ = "average_revenue_bq";

    public static void main(String[] args) throws Exception {
        QBGrab1 gab = new QBGrab1();
        OutputStream stream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\钱宝收益.xls");
        gab.writeToExcel(stream);
    }

    public JSONArray grabData() throws Exception {

        //伪装成浏览器访问，避免403
        Document doc = Jsoup.connect(pageUrl).userAgent(browse).get();

        JSONArray jsonArray = new JSONArray();
        Elements ulEls = doc.getElementsByAttributeValue("class", ulClass);
        for (Element ulEle : ulEls) {
            Elements taskEls = ulEle.getElementsByAttributeValue("class", taskClass);
            for (Element taskEl : taskEls) {
                JSONObject jsonObject = new JSONObject();
                double bReward = 0L;
                double qbReward = 0L;
                double cashDeposit = 0L;
                double penalSum = 0L;
                double daysCost = 0L;

                jsonObject.put(TASK_NAME, taskEl.getElementsByTag("p").get(0).attr("title"));
                String aUrl = taskEl.parent().attr("data-href");
                if (aUrl.contains("ntask")) {
                    jsonObject.put(TASK_ADDRESS, "http://www.qbao.com" + aUrl);
                } else if (aUrl.contains("item")) {
                    jsonObject.put(TASK_ADDRESS, aUrl);
                }

                Elements a = taskEl.getElementsByAttributeValue("class", baoquanClass);
                if (a.size() > 0) {
                    bReward = Double.valueOf(a.get(0).getElementsByTag("em").text().replace(",", ""));
                }
                Elements b = taskEl.getElementsByAttributeValue("class", baobiClass);
                if (b.size() > 0) {
                    qbReward = Double.valueOf(b.get(0).getElementsByTag("em").text().replace(",", ""));
                }

                Elements c = taskEl.getElementsByAttributeValue("class", aboutClass).get(0).getElementsByTag("em");
                for (int i = 0; i < c.size(); i++) {
                    switch (i) {
                        case 0:
                            cashDeposit = Double.valueOf(c.get(i).text().replace(",", ""));
                            break;
                        case 1:
                            penalSum = Double.valueOf(c.get(i).text().replace(",", ""));
                            break;
                        case 2:
                            daysCost = Double.valueOf(c.get(i).text().replace(",", ""));
                            break;
                        default:
                            break;
                    }
                }

                jsonObject.put(Q_REWARD, bReward);
                jsonObject.put(QB_REWARD, qbReward);
                jsonObject.put(CASH_DEPOSIT, cashDeposit);
                jsonObject.put(PENAL_SUM, penalSum);
                jsonObject.put(DAYS_COST, daysCost);

                if (cashDeposit > 0) {
                    double sYi = qbReward * 10000 / (cashDeposit * daysCost);
                    jsonObject.put(AVERAGE_REVENUE, sYi);
                } else {
                    jsonObject.put(AVERAGE_REVENUE, 0);
                }

                if (bReward > 0) {
                    double sYi = (qbReward + bReward) * 10000 / (cashDeposit * daysCost);
                    jsonObject.put(AVERAGE_REVENUE_BQ, sYi);
                } else {
                    jsonObject.put(AVERAGE_REVENUE_BQ, 0);
                }

                jsonArray.add(jsonObject);
            }
            System.out.println("生成成功");
        }
        return jsonArray;
    }

    public void writeToExcel(OutputStream outputStream) throws Exception {
        //创建工作薄
        WritableWorkbook workbook = Workbook.createWorkbook(outputStream);
        //创建新的一页
        WritableSheet sheet = workbook.createSheet("First", 0);
        //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
        Label label1 = new Label(0, 0, "任务名称");
        sheet.addCell(label1);
        Label label2 = new Label(1, 0, "天数");
        sheet.addCell(label2);
        Label label3 = new Label(2, 0, "保证金");
        sheet.addCell(label3);
        Label label4 = new Label(3, 0, "宝币奖励");
        sheet.addCell(label4);
        Label label5 = new Label(4, 0, "宝券奖励");
        sheet.addCell(label5);
        Label label6 = new Label(5, 0, "每万份收益(不含宝券)");
        sheet.addCell(label6);
        Label label7 = new Label(6, 0, "每万份收益(含宝券)");
        sheet.addCell(label7);
        Label label8 = new Label(7, 0, "任务地址");
        sheet.addCell(label8);

        JSONArray jsonArray = grabData();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject obj = (JSONObject) jsonArray.get(i);
            Label tmp = null;
            Number number = null;
            for (int j = 0; j < 8; j++) {
                switch (j) {
                    case 0:
                        tmp = new Label(j, i + 1, obj.get(TASK_NAME).toString());
                        sheet.addCell(tmp);
                        break;
                    case 1:
                        number = new jxl.write.Number(j, i + 1, Double.valueOf(obj.get(DAYS_COST).toString()));
                        sheet.addCell(number);
                        break;
                    case 2:
                        number = new jxl.write.Number(j, i + 1, Double.valueOf(obj.get(CASH_DEPOSIT).toString()));
                        sheet.addCell(number);
                        break;
                    case 3:
                        number = new jxl.write.Number(j, i + 1, Double.valueOf(obj.get(QB_REWARD).toString()));
                        sheet.addCell(number);
                        break;
                    case 4:
                        number = new jxl.write.Number(j, i + 1, Double.valueOf(obj.get(Q_REWARD).toString()));
                        sheet.addCell(number);
                        break;
                    case 5:
                        number = new jxl.write.Number(j, i + 1, Double.valueOf(obj.get(AVERAGE_REVENUE).toString()));
                        sheet.addCell(number);
                        break;
                    case 6:
                        number = new jxl.write.Number(j, i + 1, Double.valueOf(obj.get(AVERAGE_REVENUE_BQ).toString()));
                        sheet.addCell(number);
                        break;
                    case 7:
                        tmp = new Label(j, i + 1, obj.get(TASK_ADDRESS).toString());
                        sheet.addCell(tmp);
                        break;
                    default:
                        break;
                }
            }

        }

        //把创建的内容写入到输出流中，并关闭输出流
        workbook.write();
        workbook.close();
        outputStream.close();
    }

}
