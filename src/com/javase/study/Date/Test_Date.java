package com.javase.study.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * Date时间时期类
 * DateFormat类中的format方法，用于格式化日期
 * 由于是抽象类不能直接使用，需要使用它的实现类SimpleDateFormat
 */
public class Test_Date {
    private static final String FORMAT = "yyyy:MM:dd HH:mm:ss";

    public static void main(String[] args) throws ParseException {
        date1();
        date2();
        date3();
        week();
        System.out.println( new SimpleDateFormat( FORMAT ).format( new Date() ) );
        System.out.println( DateTimeFormatter.ofPattern( FORMAT ).format( LocalDateTime.now() ) );
    }

    public static void date1() {
        Date date = new Date();
        System.out.println( date );
    }

    private static void date2() {
        //1.创建SimpleDateFormat对象，构造方法中传递指定模式
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy年MM月dd日 HH时mm分ss秒" );
        //2.调用SimpleDateFormat中的format方法，按照构造方法中的指定模式，把Date日期格式转化为符合模式的字符串(文本)
        //String format(Date date)
        Date date = new Date();
        String format = sdf.format( date );
        System.out.println( format );
    }

    private static void date3() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy年MM月dd日 HH时mm分ss秒" );
        //Date parse(String source)把符合模式的字符串，解析为Date日期
        Date date = sdf.parse( "2020年10月23日 11时11分11秒" );
        System.out.println( date );
    }

    /**
     * 用程序判断2018年2月14日是星期几
     */
    public static void week() throws ParseException {
        //将字符串时间转为Date
        Date nowDate = new SimpleDateFormat( "yyyy年MM月dd日" ).parse( "2019年9月22日" );
        //获取转化后时间的毫秒值
        long time = nowDate.getTime();
        //将当前时间设置为获取到的时间并格式化
        String format = new SimpleDateFormat( "EEEE" ).format( new Date( time ) );
        System.out.println( format );
    }
}
