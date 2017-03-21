package com.ashur.common;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author ZXY
 * @ClassName: QBGrab2
 * @Description:
 * @date 2017/3/20 17:23
 */
public class QBGrab2 {

    private static String pageUrl = "https://agent.qbao.com/agent/web/hall";


    private static String TASK_NAME = "task_name";
    private static String TASK_ADDRESS = "task_address";
    private static String Q_REWARD = "joinFee";//加盟费
    private static String QB_REWARD = "qb_reward";
    private static String CASH_DEPOSIT = "cash_deposit";
    private static String PENAL_SUM = "penal_sum";
    private static String DAYS_COST = "days_cost";
    private static String AVERAGE_REVENUE = "average_revenue";
    private static String AVERAGE_REVENUE_BQ = "average_revenue_bq";

    public static void main(String[] args) throws Exception{
        QBGrab2 qbGrab2 = new QBGrab2();
        OutputStream stream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\钱宝收益.xls");
        qbGrab2.writeToExcel(stream);
    }

    public JSONArray grabData() throws Exception {
        String s = HttpUtils.sendPost(pageUrl, null, "utf-8");
        JSONObject jsonObject =  JsonUtils.readValue(s,JSONObject.class);
        return jsonObject.getJSONObject("data").getJSONArray("rows");
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
