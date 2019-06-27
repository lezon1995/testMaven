package com.esb;

import org.w3c.dom.Node;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.net.URL;

public class Test1031 {
    public static void main(String args[]) {
        try {
            // ==================================================
            SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnFactory.createConnection();
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
            SOAPElement header = bodyElement.addChildElement(new QName(nameSpace, "Header", "NS1"));
            header.addChildElement(new QName(nameSpace, "version", "NS1")).addTextNode("0.1");
            header.addChildElement(new QName(nameSpace, "source", "NS1")).addTextNode("IBS");
            header.addChildElement(new QName(nameSpace, "service", "NS1")).addTextNode("SRV.DEP.inwardClear");
            header.addChildElement(new QName(nameSpace, "date", "NS1")).addTextNode("2019-04-24");
            header.addChildElement(new QName(nameSpace, "time", "NS1")).addTextNode("11:09:01");
            header.addChildElement(new QName(nameSpace, "reqJournalNo", "NS1")).addTextNode("6823231182655");
            SOAPElement callApp =
                    bodyElement.addChildElement(new QName(nameSpace, "Body", "NS1")).addChildElement(new QName(nameSpace,"callApp", "NS1"));
            SOAPElement appheader = callApp.addChildElement(new QName(nameSpace, "Header", "NS1"));
            appheader.addChildElement(new QName(nameSpace, "previewFlag", "NS1")).addTextNode("Y");
            appheader.addChildElement(new QName(nameSpace, "channel", "NS1")).addTextNode("5");
            SOAPElement appbody = callApp.addChildElement(new QName(nameSpace, "Body", "NS1"))
                    .addChildElement(new QName(nameSpace, "inwardClear", "NS1"));
            appbody.addChildElement(new QName(nameSpace, "acctNumber1", "NS1")).addTextNode("00000002052492925");
            appbody.addChildElement(new QName(nameSpace, "hiddenAmount1", "NS1")).addTextNode("0");
            appbody.addChildElement(new QName(nameSpace, "amount1", "NS1")).addTextNode("1000");
            appbody.addChildElement(new QName(nameSpace, "promono1", "NS1")).addTextNode("GT");
            appbody.addChildElement(new QName(nameSpace, "defInteger4", "NS1")).addTextNode("0");
            appbody.addChildElement(new QName(nameSpace, "acctNumber2", "NS1")).addTextNode("09001074468421118");
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
            // 打印客户端发出的soap报文，做验证测试
            System.out.println(" REQUEST: ===========================================================================");
            message.writeTo(System.out);
            System.out.println(" ");
            /*
             * 实际的消息是使用 call()方法发送的，该方法接收消息本身和目的地作为参数，并返回第二个 SOAPMessage 作为响应。
             * call方法的message对象为发送的soap报文，url为mule配置的inbound端口地址。
             */
            URL url = new URL("http://172.31.252.213:7800/TFBService");
            System.out.println(url);
            // 响应消息
            // ===========================================================================
            SOAPMessage reply = connection.call(message, url);
            //reply.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "gb2312");
            // 打印服务端返回的soap报文供测试
            System.out.println("RESPONSE: ===========================================================================");
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
            /*
             * 模拟客户端A，异常处理测试
             */
            SOAPBody ycBody = reply.getSOAPBody();
            Node ycResp = ycBody.getFirstChild();
            System.out.print("returnValue:" + ycResp.getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
