package com.ken.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**年*/
    public static final int YEAR_RETURN = 0;
    /**月*/
    public static final int MONTH_RETURN = 1;
    /**日*/
    public static final int DAY_RETURN = 2;
    /**时*/
    public static final int HOUR_RETURN= 3;
    /**分*/
    public static final int MINUTE_RETURN = 4;
    /**秒*/
    public static final int SECOND_RETURN = 5;

    /**年*/
    public static final String YYYY = "yyyy";
    /**年-月*/
    public static final String YYYYMM = "yyyy-MM";
    /**年-月-日*/
    public static final String YYYYMMDD = "yyyy-MM-dd";
    /**年-月-日-时*/
    public static final String YYYYMMDDHH= "yyyy-MM-dd HH";
    /**年-月-日-时-分*/
    public static final String YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    /**年-月-日-时-分-秒*/
    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    public static long getBetween(String beginTime, String endTime, String formatPattern, int returnPattern) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatPattern);
        Date beginDate = simpleDateFormat.parse(beginTime);
        Date endDate = simpleDateFormat.parse(endTime);

        Calendar beginCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        beginCalendar.setTime(beginDate);
        endCalendar.setTime(endDate);
        switch (returnPattern) {
            case YEAR_RETURN:
                return DateUtils.getByField(beginCalendar, endCalendar, Calendar.YEAR);
            case MONTH_RETURN:
                return DateUtils.getByField(beginCalendar, endCalendar, Calendar.YEAR)*12 + DateUtils.getByField(beginCalendar, endCalendar, Calendar.MONTH);
            case DAY_RETURN:
                return DateUtils.getTime(beginDate, endDate)/(24*60*60*1000);
            case HOUR_RETURN:
                return DateUtils.getTime(beginDate, endDate)/(60*60*1000);
            case MINUTE_RETURN:
                return DateUtils.getTime(beginDate, endDate)/(60*1000);
            case SECOND_RETURN:
                return DateUtils.getTime(beginDate, endDate)/1000;
            default:
                return 0;
        }
    }

    private static long getByField(
            Calendar beginCalendar,Calendar endCalendar, int calendarField){
        return endCalendar.get(calendarField) - beginCalendar.get(calendarField);
    }

    private static long getTime(Date beginDate, Date endDate){
        return endDate.getTime() - beginDate.getTime();
    }
    public static void main(String[] args) {
        try {
            System.out.println(DateUtils.getBetween(
                    "2013-05-02 09:19:19", "2013-05-05 09:18:18",
                    DateUtils.YYYYMMDDHHMMSS, DateUtils.SECOND_RETURN));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
