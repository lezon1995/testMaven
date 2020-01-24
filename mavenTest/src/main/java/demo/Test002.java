package demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class Test002 {
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String dateTransformBetweenTimeZone(Date sourceDate, DateFormat formatter,
                                                      TimeZone sourceTimeZone, TimeZone targetTimeZone) {
        Long targetTime = sourceDate.getTime() - sourceTimeZone.getRawOffset() + targetTimeZone.getRawOffset();
        return getTime(new Date(targetTime), formatter);
    }

    public static String getTime(Date date, DateFormat formatter) {
        return formatter.format(date);
    }

    public static String convertDateBetweenTimeZone(String timeZone, Long createTime) {
        DateFormat dateFormat = new SimpleDateFormat("Z");
        String localTimeZone = dateFormat.format(new Date());
        TimeZone srcTimeZone = TimeZone.getTimeZone("GMT" + localTimeZone);
        TimeZone destTimeZone = TimeZone.getTimeZone(timeZone);
        DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        String destDateTime = dateTransformBetweenTimeZone(new Date(createTime), formatter, srcTimeZone, destTimeZone);
        return destDateTime;
    }

    public static void main(String[] args) {
        Long datetime = System.currentTimeMillis();
        System.out.println(datetime);
        System.out.println(convertDateBetweenTimeZone("UTC-4", datetime));
    }
}
