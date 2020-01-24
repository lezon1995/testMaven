package work.sql;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Wentworth .
 * @date 2019-08-28 16:21
 */
public class Y {
            public static void main(String[] args) {
        String str="BCRB2G6gZYUZ%2FTeF5nr3BrBd0mv5aX4u3xTX8rHsh0L0cHTc%2BlsAXx1Y84nTxqor52QKrwVWKWHj%0AHD2KWjPApdkaCBx7IYZTglzUeHQXPrXJFpcnwHOXqRbzm33xxHh3n4K1c0uifK3HBbo9EJtS%2B2Ca%0AcU4mc1iRuVYKUjP%2B6XTf1HbQoRou4kunt7tCwXcMWpktFM%2BQjiNWAVtR7RG1FIIYLSfcWxbkBprp%0A2ujA3%2Fb1%2BReGq0MAhKw7sXzffSxma7hFzR%2B8Dt9FQeQ6%2BsBjp985fFpCoEDg5egDpWknoc6Y2vbA%0A|预订|5e0000G58260|G582|NGH|WHN|HGH|VXN|16:43|21:17|04:34|N|wp%2BAMrkoDecQoRSZ8vVp1R2BwOBwwnnYwZHkQEhYndvso0e1|20191001|3|H2|04|15|0|0|||||||||||无|无|无||O0M090|OM9|0|1|";
        String[] split = str.split("\\|");
        for (int i = 0; i < split.length; i++) {
            System.out.println(i+"-"+split[i]);
        }
            SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss", Locale.US);
            String format = sdf.format(new Date());
            System.out.println(format+"");
        }
//    public static void main(String[] args) {
//        String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
//                "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
//                "<title>中国铁路12306</title>\n" +
//                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
//                "<link href=\"/otn/resources/css/validation.css\" rel=\"stylesheet\" />\n" +
//                "<link href=\"/otn/resources/merged/common_css.css?cssVersion=1.9053\" rel=\"stylesheet\" />\n" +
//                "<link rel=\"icon\" href=\"/otn/resources/images/ots/favicon.ico\" type=\"image/x-icon\" />\n" +
//                "<link rel=\"shortcut icon\" href=\"/otn/resources/images/ots/favicon.ico\" type=\"image/x-icon\" />\n" +
//                "<script>\n" +
//                "/*<![CDATA[*/\n" +
//                " var ctx='/otn/';\n" +
//                " var globalRepeatSubmitToken = '54f654406cbf672e067eb578624c36c1';\n" +
//                " var global_lang = 'zh_CN';\n" +
//                " var sessionInit = '\\u6731\\u4EAE';";
//
//        String submitTokenKey = "globalRepeatSubmitToken";
////        html = new String(html.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
//        int startIndex = html.indexOf(submitTokenKey) + submitTokenKey.length() + 4;
//        String substring = html.substring(startIndex);
//        String substring1 = substring.substring(0, substring.indexOf("'"));
//        System.out.println(substring1);
//        String repeatToken = html.substring(startIndex, startIndex + 32);
//        System.out.println(repeatToken);
//    }
}


