package com.design_pattern;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

    static String[] s1 = new String[]{"Y", "N"};
    static String[] s2 = new String[]{"Y", "N", "D"};
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private static String firstDay;
    private static String lastDay;

    public static void main(String[] args) throws InterruptedException {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        long current=System.currentTimeMillis();//当前时间毫秒数
//        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
//        long twelve=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
//        System.out.println(current+"=="+format.format(new Date(current)));
//        System.out.println(zero+"=="+format.format(new Date(zero)));
//        System.out.println(twelve+"=="+format.format(new Date(twelve)));
//        String s = "YYYY-MM-DD-2B";
//        System.out.println(s.substring(11,12));
        Calendar c = Calendar.getInstance();//获取当前日期
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        firstDay = format.format(c.getTime());
        System.out.println("-----1------firstDay:" + firstDay+"="+c.getTime().getTime());
        //获取前月的最后一天
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);//设置为1号,当前日期既为本月第一天
        cale.set(Calendar.HOUR_OF_DAY, 23);
        cale.set(Calendar.MINUTE, 59);
        cale.set(Calendar.SECOND, 59);
        lastDay = format.format(cale.getTime());
        System.out.println("-----2------lastDay:" + lastDay+"="+cale.getTime().getTime());
    }


    public static int[] generate1M() {
        return new int[256 * 1024];
    }
}
