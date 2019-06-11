package cn.qrcode;

import java.io.File;
import java.io.FileInputStream;

public class Demo {
    public static void main(String[] args) throws Exception {
        int width = 1280;
        int height = 720;
        QrDecoderDemo qrDecoderDemo = new QrDecoderDemo();
        File file = new File("E:\\qrcode\\微信图片_20190517155708.jpg");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        inputStream.read(bytes);
        String decode = qrDecoderDemo.decode(bytes, width, height);
        System.out.println(decode);
    }
}
