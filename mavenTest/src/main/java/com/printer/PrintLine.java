package com.printer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ POS小票打印机  网口无驱打印
 * <p>
 * 调用方法  new PrintLine().print(list,map,string);
 */
public class PrintLine {
    private static final String PRINT_IP = "10.129.0.250";
    private static final int PRINT_PORT = 9100;
    private Socket socket = null;
    private OutputStream socketOut = null;
    private OutputStreamWriter writer = null;

    // 条码打印指令
    private static final byte[] printCode = new byte[9];
    // 字体横线放大一倍
    private static final byte[] fdFont = new byte[3];
    // 一倍字体
    private static final byte[] font1 = new byte[3];
    // 二倍字体
    private static final byte[] font2 = new byte[3];
    // 三倍字体
    private static final byte[] font3 = new byte[3];
    // 字体加粗指令
    private static final byte[] fontB = new byte[3];
    // 取消字体加粗指令
    private static final byte[] clearFontB = new byte[3];
    // 清除字体放大
    private static final byte[] clearFont = new byte[3];
    // 下划线模式
    private static final byte[] underlineFont = new byte[3];

    // 取消下划线模式
    private static final byte[] clearUnderlineFont = new byte[3];
    // 左边距
    private static final byte[] marginLeft = new byte[4];
    // 位图
    private static byte[] bitmap;

    /**
     * @throws IOException
     */
    public PrintLine() throws IOException {
        // 建立打印机连接
        socket = new Socket(PRINT_IP, PRINT_PORT);
        socketOut = socket.getOutputStream();
        writer = new OutputStreamWriter(socketOut, "GBK");
    }

    public static void main(String[] args) throws IOException {
        //设置打印机指令
        setCommandByte();
        List<PrintItem> list = new ArrayList<>();
        list.add(new PrintItem("商户名称及编号(MERCHANT NAME&CODE):", new String[]{"广东天适樱花悠乐园有限公司", "360208020168"}, 16));
        list.add(new PrintItem("银联商户号(UNION PAY MERCHANT CODE):", new String[]{"102581079960164"}, 15));
        list.add(new PrintItem("交易日期/时间(DATE/TIME):", new String[]{"2019/04/12 10:24:29"}, 14));
        list.add(new PrintItem("交易类型(TRAMS TYPE):", new String[]{"二维码消费"}, 13));
        list.add(new PrintItem("工行订单号:", new String[]{"36022401866800120192277273493"}, 12));
        list.add(new PrintItem("第三方订单号(PAD订单号):", new String[]{"420000026220190227446"}, 11));
        list.add(new PrintItem("总计(TOTAL):", new String[]{"RMB 0.30"}, 10));
        Collections.sort(list);

        PrintLine printLine = new PrintLine();
        printLine.print(list);
    }

    private static void setCommandByte() {
        printCode[0] = 0x1d;
        printCode[1] = 0x68;
        printCode[2] = 120;
        printCode[3] = 0x1d;
        printCode[4] = 0x48;
        printCode[5] = 0x10;
        printCode[6] = 0x1d;
        printCode[7] = 0x6B;
        printCode[8] = 0x02;

        fdFont[0] = 0x1b;
        fdFont[1] = 0x21;
        fdFont[2] = (byte) 0b0011_1000;


        font1[0] = 0x1d;
        font1[1] = 0x21;
        font1[2] = (byte) 0b0000_0000;

        font2[0] = 0x1d;
        font2[1] = 0x21;
        font2[2] = (byte) 0b0001_0000;

        font3[0] = 0x1d;
        font3[1] = 0x21;
        font3[2] = (byte) 0b0010_0010;

        clearFont[0] = 0x1b;
        clearFont[1] = 0x21;
        clearFont[2] = 0b0000_0000;

        fontB[0] = 0x1b;//27
        fontB[1] = 0x21;//33
        fontB[2] = (byte) 0b0000_1000;

        clearFontB[0] = 0x1b;//27
        clearFontB[1] = 0x21;//33
        clearFontB[2] = 0b0000_0000;

        underlineFont[0] = 0x1c;
        underlineFont[1] = 0x21;
        underlineFont[2] = (byte) 0b0011_1000;

        clearUnderlineFont[0] = 0x1c;
        clearUnderlineFont[1] = 0x21;
        clearUnderlineFont[2] = 0b0000_0000;


        marginLeft[0] = 0x1d;
        marginLeft[1] = 0x4c;
        marginLeft[2] = 0b0000_0000;
        marginLeft[3] = 0b0000_0000;

//        try {
//            bitmap = ImagePixelUtils.imagePixelToPosByte_24("C:\\Users\\yckj1224\\Desktop\\logo.bmp", 33);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

//    public void print(Map<String, String> printData, Map<String, String> lableMap) {
//        try {
//
//            writeTitle(lableMap);
//            writer.flush();// 关键,很重要,不然指令一次性输出,后面指令覆盖前面指令,导致取消放大指令无效
//
//            writeBolder(lableMap.get("label_merchant_name&code"));
//            writer.write(printData.get("data_merchant_name") + "\r\n");
//            writer.write(printData.get("data_merchant_code"));
//            writer.flush();
//
//            writeBolder(lableMap.get("label_union_pay_merchant_code"));
//            writer.write(printData.get("data_union_pay_merchant_code"));
//            writer.flush();
//
//            writeBolder(lableMap.get("label_trading_datetime"));
//            writer.write(printData.get("data_trading_datetime"));
//            writer.flush();
//
//            writeBolder(lableMap.get("label_trade_type"));
//            writer.write(printData.get("data_qr_code"));
//            writer.flush();
//
//            writeBolder(lableMap.get("label_icbc_order_number"));
//            writer.write(printData.get("data_icbc_order_number"));
//            writer.flush();
//
//            writeBolder(lableMap.get("label_third_party_order_number"));
//            writer.write(printData.get("data_third_party_order_number"));
//            writer.flush();
//
//            writeBolder(lableMap.get("label_total"));
//            writer.write(printData.get("data_total") + "\r\n");
//            writer.write("-----------------------------");
//
//            writer.flush();// 关键,很重要,不然指令一次性输出,后面指令覆盖前面指令,导致取消放大指令无效
//
//            // 下面指令为打印完成后自动走纸
//            writer.write(27);
//            writer.write(100);
//            writer.write(4);
//            writer.write(10);
//
//            writer.close();
//            socketOut.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public void print(List<PrintItem> list) {
        try {

//            socketOut.write(bitmap);

            writeTitle();
            writer.flush();// 关键,很重要,不然指令一次性输出,后面指令覆盖前面指令,导致取消放大指令无效

            for (PrintItem item : list) {
                writeItem(item);
            }
            writer.write("\r\n");
            writer.write("-----------------------------");
            writer.flush();// 关键,很重要,不然指令一次性输出,后面指令覆盖前面指令,导致取消放大指令无效

            // 下面指令为打印完成后自动走纸
            writer.write(27);
            writer.write(100);
            writer.write(4);
            writer.write(10);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                socketOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    private void writeTitle(Map<String, String> lableMap) throws Exception {
//        socketOut.write(fdFont);// 字体放大X
//        writer.write(lableMap.get("label_acronym"));
//        socketOut.write(font2);// 下划线
//        writer.write(lableMap.get("label_title"));
//        writer.flush();// 关键,很重要,不然指令一次性输出,后面指令覆盖前面指令,导致取消放大指令无效
//        socketOut.write(underlineFont);// 下划线
//        writer.write("————————————————");
//        writer.flush();// 关键,很重要,不然指令一次性输出,后面指令覆盖前面指令,导致取消放大指令无效
//        socketOut.write(clearFont);
//        socketOut.write(clearUnderlineFont);
//        writer.write("      " + lableMap.get("label_card_holder") + "\r\n");
//    }

    private void writeTitle() throws Exception {
        socketOut.write(fdFont);// 字体放大X
        writer.write("ICBC");
        socketOut.write(font2);// 下划线
        writer.write("中国工商银行");
        writer.flush();// 关键,很重要,不然指令一次性输出,后面指令覆盖前面指令,导致取消放大指令无效
        socketOut.write(underlineFont);// 下划线
        writer.write("————————————————");
        writer.flush();// 关键,很重要,不然指令一次性输出,后面指令覆盖前面指令,导致取消放大指令无效
        socketOut.write(clearFont);
        socketOut.write(clearUnderlineFont);
        writer.write("      " + "持卡人存根CardHolder Copy" + "\r\n");
    }

    public void writeBolder(String text) throws Exception {
        socketOut.write(fontB);// 字体加粗
        socketOut.write(10);
        writer.write(text);
        writer.flush();// 关键,很重要,不然指令一次性输出,后面指令覆盖前面指令,导致取消放大指令无效
        socketOut.write(clearFontB);
        socketOut.write(10);
    }

    public void writeItem(PrintItem item) throws Exception {
        writeBolder(item.getLabel());
        String[] datas = item.getDatas();
        for (int i = 0; i < datas.length; i++) {
            writer.write(datas[i]);
            if (datas.length > 1 && i != datas.length - 1) {
                writer.write("\r\n");
            }
        }
        writer.flush();
    }

    /**
     * 字符串长度补齐,方便打印时对齐,美化打印页面,不过中文计算好像有点问题
     *
     * @param strs 源字符
     * @param len  指定字符长度
     * @return
     * @throws UnsupportedEncodingException
     */
    public String fixStringLenth(int type, String strs, int len) {
        String strtemp = strs;
        int len1 = strs.length();
        switch (type) {
            case 0:
                while (strtemp.length() < len) {
                    strtemp += " ";
                }
                break;
            case 1:
                while (strtemp.length() < len) {
                    strtemp += " ";
                }
                break;
            default:

                break;
        }
        return strtemp;
    }


}
