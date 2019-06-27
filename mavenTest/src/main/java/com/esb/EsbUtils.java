package com.esb;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.net.URL;
import java.util.Random;

/**
 * @author YCKJ1409
 * Esb工具類
 */
public class EsbUtils {

    private static String[] names = new String[]{"0", "张三", "李四", "王五", "赵六", "彭万里", "马宏宇", "章汉夫", "孙杰", "吕显祖", "吴家栋"};
    private static String[] ids = new String[]{"0", "0001", "0002", "0003", "0004", "0005", "0006", "0007", "0008", "0009", "0010"};
    private static Random random = new Random();

    private static Integer MAX_BLG_CODE_LENGTH = 16;

    /**
     * 請求
     *
     * @param fromAcctNo 扣款账户
     * @param toAcctNo   收款账户
     * @param money
     * @return
     */
//    public static ResponseData<Boolean> sendRequestToEsb(String fromAcctNo,String toAcctNo, Integer money) {
//        //TODO 發送xml to esb 得到結果
//        if (fromAcctNo == null && ("").equals(fromAcctNo)) {
//            return ResponseUtil.error("付款賬戶不能為空", "12346");
//        }
//        if(toAcctNo == null && ("").equals(toAcctNo)){
//            return ResponseUtil.error("收款賬戶不能為空", "12346");
//        }
//        if (money < 0) {
//            return ResponseUtil.error("金額不能為空", "12345");
//        }
//        if(fromAcctNo.length()<=MAX_BLG_CODE_LENGTH){
//            fromAcctNo = addZeroForNum(fromAcctNo,MAX_BLG_CODE_LENGTH);
//        }
//        if(toAcctNo.length()<=MAX_BLG_CODE_LENGTH){
//            toAcctNo = addZeroForNum(toAcctNo,MAX_BLG_CODE_LENGTH);
//        }
//        //TODO 调用esb接口代码，获取返回结果
//        return ResponseUtil.ok(true);
//    }


    /**
     * 格式化扣款账号，不足17位的在前面补0
     *
     * @param str       字符串
     * @param strLength 位数
     * @return
     */
    public static String addZeroForNum(String str, int strLength) {
        int strLen = str.length();
        StringBuffer sb = null;
        while (strLen < strLength) {
            sb = new StringBuffer();
            sb.append("0").append(str);
            str = sb.toString();
            strLen = str.length();
        }
        return str;
    }

    //模拟数据
    public static String mockData() {
        //i 0~9
        int i = random.nextInt(10);
        return ids[i] + "-" + names[i];
    }

    /**
     * 收款代码
     *
     * @return
     */
    public static SOAPMessage first021031(String fromAcctNo, String toAcctNo, Integer money) {
        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage message = messageFactory.createMessage();
            // 创建soap消息主体==========================================
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            SOAPBody body = envelope.getBody();
            String nameSpace = "http://www.taifungbank.com/TFBService";
            String headerName = "header";
            String bodyName = "body";
            SOAPElement bodyElement = body.addChildElement(new QName(nameSpace,
                    "callService", "NS1"));
            SOAPElement header = bodyElement.addChildElement(new QName(nameSpace, "header", "NS1"));
            header.addChildElement(new QName(nameSpace, "version", "NS1")).addTextNode("0.1");
            header.addChildElement(new QName(nameSpace, "source", "NS1")).addTextNode("IBS");
            header.addChildElement(new QName(nameSpace, "service", "NS1")).addTextNode("APP.BANCS.021031");

            SOAPElement callApp =
                    bodyElement.addChildElement(new QName(nameSpace, "body", "NS1")).addChildElement(new QName(nameSpace,
                            "callApp", "NS1"));
            SOAPElement appheader = callApp.addChildElement(new QName(nameSpace, "header", "NS1"));
            appheader.addChildElement(new QName(nameSpace, "acDate", "NS1")).addTextNode("2024-01-30");
            appheader.addChildElement(new QName(nameSpace, "previewFlag", "NS1")).addTextNode("Y");
            appheader.addChildElement(new QName(nameSpace, "channel", "NS1")).addTextNode("0");
            appheader.addChildElement(new QName(nameSpace, "postControl", "NS1")).addTextNode("1");
            appheader.addChildElement(new QName(nameSpace, "branchCode", "NS1")).addTextNode("500");
            appheader.addChildElement(new QName(nameSpace, "tellerId", "NS1")).addTextNode("5009518");

            SOAPElement appbody = callApp.addChildElement(new QName(nameSpace, "body", "NS1"))
                    .addChildElement(new QName(nameSpace, "inwardClear", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "acctNumber1", "NS1")).addTextNode(fromAcctNo);
            appbody.addChildElement(new QName(nameSpace, "hiddenAmount1", "NS1")).addTextNode("0");
            appbody.addChildElement(new QName(nameSpace, "amount1", "NS1")).addTextNode(String.valueOf(money));
            appbody.addChildElement(new QName(nameSpace, "promono1", "NS1")).addTextNode("GT");
            appbody.addChildElement(new QName(nameSpace, "defInteger4", "NS1")).addTextNode("0");
            appbody.addChildElement(new QName(nameSpace, "acctNumber2", "NS1")).addTextNode(toAcctNo);
            appbody.addChildElement(new QName(nameSpace, "defaultString4", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "defaultString5", "NS1")).addTextNode("XAH");
            appbody.addChildElement(new QName(nameSpace, "accCurrCode1", "NS1")).addTextNode("HKD");
            appbody.addChildElement(new QName(nameSpace, "txnAmount1", "NS1")).addTextNode("1000");
            appbody.addChildElement(new QName(nameSpace, "txnCurrCode1", "NS1")).addTextNode("HKD");
            appbody.addChildElement(new QName(nameSpace, "baseAmount1", "NS1")).addTextNode("1000");
            appbody.addChildElement(new QName(nameSpace, "commission1", "NS1")).addTextNode("0");
            appbody.addChildElement(new QName(nameSpace, "change1", "NS1")).addTextNode("0");
            appbody.addChildElement(new QName(nameSpace, "rateType1", "NS1")).addTextNode("01");
            appbody.addChildElement(new QName(nameSpace, "currVersion1", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "defInteger2", "NS1")).addTextNode("00");
            appbody.addChildElement(new QName(nameSpace, "defInteger21", "NS1")).addTextNode("00");
            appbody.addChildElement(new QName(nameSpace, "defaultString3", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "stmtnrtv1", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "voucherType1", "NS1")).addTextNode("9001");
            appbody.addChildElement(new QName(nameSpace, "voucherNo1", "NS1")).addTextNode("11");
            appbody.addChildElement(new QName(nameSpace, "withdrawalType1", "NS1")).addTextNode("9");
            appbody.addChildElement(new QName(nameSpace, "issueVoucherDate1", "NS1")).addTextNode("0");
            appbody.addChildElement(new QName(nameSpace, "password1", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "subacctType", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "currVersion2", "NS1")).addTextNode("0001");
            appbody.addChildElement(new QName(nameSpace, "rateTypeAcct", "NS1")).addTextNode("01");
            appbody.addChildElement(new QName(nameSpace, "exchRateAcct1", "NS1")).addTextNode("10000");
            appbody.addChildElement(new QName(nameSpace, "cardNumber", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "paymentPasswordSucceedFlag", "NS1")).addTextNode("N");
            appbody.addChildElement(new QName(nameSpace, "oldFlag1", "NS1")).addTextNode("00");
            appbody.addChildElement(new QName(nameSpace, "currVersion3", "NS1")).addTextNode("0001");
            appbody.addChildElement(new QName(nameSpace, "rateType2", "NS1")).addTextNode("01");
            appbody.addChildElement(new QName(nameSpace, "fromRate", "NS1")).addTextNode("10000");
            appbody.addChildElement(new QName(nameSpace, "toRate", "NS1")).addTextNode("10000");
            appbody.addChildElement(new QName(nameSpace, "fcyStatisticsNo", "NS1")).addTextNode("000000");
            message.saveChanges();
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SOAPMessage first021051(String fromAcctNo, String toAcctNo, Integer money) {
        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage message = messageFactory.createMessage();
            // 创建soap消息主体==========================================
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            SOAPBody body = envelope.getBody();
            String nameSpace = "http://www.taifungbank.com/TFBService";
            String headerName = "header";
            String bodyName = "body";
            SOAPElement bodyElement = body.addChildElement(new QName(nameSpace,
                    "callService", "NS1"));
            SOAPElement header = bodyElement.addChildElement(new QName(nameSpace, "header", "NS1"));
            header.addChildElement(new QName(nameSpace, "version", "NS1")).addTextNode("0.1");
            header.addChildElement(new QName(nameSpace, "source", "NS1")).addTextNode("IBS");
            header.addChildElement(new QName(nameSpace, "service", "NS1")).addTextNode("APP.BANCS.021031");

            SOAPElement callApp =
                    bodyElement.addChildElement(new QName(nameSpace, "body", "NS1")).addChildElement(new QName(nameSpace,
                            "callApp", "NS1"));
            SOAPElement appheader = callApp.addChildElement(new QName(nameSpace, "header", "NS1"));
            appheader.addChildElement(new QName(nameSpace, "acDate", "NS1")).addTextNode("2024-01-30");
            appheader.addChildElement(new QName(nameSpace, "previewFlag", "NS1")).addTextNode("Y");
            appheader.addChildElement(new QName(nameSpace, "channel", "NS1")).addTextNode("0");
            appheader.addChildElement(new QName(nameSpace, "postControl", "NS1")).addTextNode("1");
            appheader.addChildElement(new QName(nameSpace, "branchCode", "NS1")).addTextNode("500");
            appheader.addChildElement(new QName(nameSpace, "tellerId", "NS1")).addTextNode("5009518");

            SOAPElement appbody = callApp.addChildElement(new QName(nameSpace, "body", "NS1"))
                    .addChildElement(new QName(nameSpace, "inwardClear", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "acctNumber1", "NS1")).addTextNode(fromAcctNo);
            appbody.addChildElement(new QName(nameSpace, "hiddenAmount1", "NS1")).addTextNode("0");
            appbody.addChildElement(new QName(nameSpace, "amount1", "NS1")).addTextNode("1000");
            appbody.addChildElement(new QName(nameSpace, "promono1", "NS1")).addTextNode("GT");
            appbody.addChildElement(new QName(nameSpace, "defInteger4", "NS1")).addTextNode("0");
            appbody.addChildElement(new QName(nameSpace, "acctNumber2", "NS1")).addTextNode(toAcctNo);
            appbody.addChildElement(new QName(nameSpace, "defaultString4", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "defaultString5", "NS1")).addTextNode("XAH");
            appbody.addChildElement(new QName(nameSpace, "accCurrCode1", "NS1")).addTextNode("HKD");
            appbody.addChildElement(new QName(nameSpace, "txnAmount1", "NS1")).addTextNode("1000");
            appbody.addChildElement(new QName(nameSpace, "txnCurrCode1", "NS1")).addTextNode("HKD");
            appbody.addChildElement(new QName(nameSpace, "baseAmount1", "NS1")).addTextNode("1000");
            appbody.addChildElement(new QName(nameSpace, "commission1", "NS1")).addTextNode("0");
            appbody.addChildElement(new QName(nameSpace, "change1", "NS1")).addTextNode("0");
            appbody.addChildElement(new QName(nameSpace, "rateType1", "NS1")).addTextNode("01");
            appbody.addChildElement(new QName(nameSpace, "currVersion1", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "defInteger2", "NS1")).addTextNode("00");
            appbody.addChildElement(new QName(nameSpace, "defInteger21", "NS1")).addTextNode("00");
            appbody.addChildElement(new QName(nameSpace, "defaultString3", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "stmtnrtv1", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "voucherType1", "NS1")).addTextNode("9001");
            appbody.addChildElement(new QName(nameSpace, "voucherNo1", "NS1")).addTextNode("11");
            appbody.addChildElement(new QName(nameSpace, "withdrawalType1", "NS1")).addTextNode("9");
            appbody.addChildElement(new QName(nameSpace, "issueVoucherDate1", "NS1")).addTextNode("0");
            appbody.addChildElement(new QName(nameSpace, "password1", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "subacctType", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "currVersion2", "NS1")).addTextNode("0001");
            appbody.addChildElement(new QName(nameSpace, "rateTypeAcct", "NS1")).addTextNode("01");
            appbody.addChildElement(new QName(nameSpace, "exchRateAcct1", "NS1")).addTextNode("10000");
            appbody.addChildElement(new QName(nameSpace, "cardNumber", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "paymentPasswordSucceedFlag", "NS1")).addTextNode("N");
            appbody.addChildElement(new QName(nameSpace, "oldFlag1", "NS1")).addTextNode("00");
            appbody.addChildElement(new QName(nameSpace, "currVersion3", "NS1")).addTextNode("0001");
            appbody.addChildElement(new QName(nameSpace, "rateType2", "NS1")).addTextNode("01");
            appbody.addChildElement(new QName(nameSpace, "fromRate", "NS1")).addTextNode("10000");
            appbody.addChildElement(new QName(nameSpace, "toRate", "NS1")).addTextNode("10000");
            appbody.addChildElement(new QName(nameSpace, "fcyStatisticsNo", "NS1")).addTextNode("000000");
            message.saveChanges();
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String args[]) {
        try {
            System.out.println(" REQUEST: ");
            //11位 205-2-49292-5 205-2-49293-3
//            String acct1 = "105 1 00671 97";
            String acct1 = "2052492925";
            //17位 0900 107 4468 42 1118
//            String acct2 = "0900 104 3449 99 1004";
            String acct2 = "09001074468421118";
            int amount = 1000;
            SOAPMessage message = EsbUtils.first021031(acct1, acct2, amount);
            message.writeTo(System.out);
            // 创建连接
            // ==================================================
            SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory
                    .newInstance();
            SOAPConnection connection = soapConnFactory.createConnection();
            URL url = new URL("http://172.31.252.213:7800/TFBService");
            System.out.println(url);
            // 响应消息
            // ===========================================================================
            SOAPMessage reply = connection.call(message, url);
            System.out.println("RESPONSE:");
            // ==================创建soap消息转换对象
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // Extract the content of the reply======================提取消息内容
            Source sourceContent = reply.getSOAPPart().getContent();
            // Set the output for the transformation
            StreamResult result = new StreamResult(System.out);
            transformer.transform(sourceContent, result);
            // Close the connection 关闭连接 ==============
            System.out.println("");
            connection.close();
            System.out.println(" ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
